package com.example.capstone.store.controller;

import com.example.capstone.store.database.dao.ProductDAO;
import com.example.capstone.store.database.entity.Product;
import com.example.capstone.store.form.CreateProductFormBean;
import com.example.capstone.store.service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    public ProductController() {
    }

    @PostConstruct
    public void init() {

    }


    @Autowired
    private ProductDAO productDao;


    @Autowired
    private ProductService productService;



    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView("product/detail");


        Product product = productDao.findById(productId);
        response.addObject("product", product);

        return response;
    }



    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("product/create");

        loadDropdowns(response);

        return response;
    }

    private void loadDropdowns(ModelAndView response) {
        List<Product> reportsToEmployees = productDAO.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);


    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET )
    public ModelAndView edit(@RequestParam(required = false) Integer productId) {

        ModelAndView response = new ModelAndView("product/create");

        loadDropdowns(response);


        if (productId != null) {

            Product product = productDao.findById(productId);
            if (product != null) {

                CreateProductFormBean form = new CreateProductFormBean();

                form.setProductId(product.getId());
                form.setProductName(product.getName());
                form.setProductPrice(product.getPrice());
                form.setProductImageUrl(product.getImageUrl());
                form.setProductDescription(product.getDescription());


                response.addObject("form", form);
            } else {

                response.addObject("errorMessage", "The product was not found in the database.");
            }
        }

        return response;
    }


    @RequestMapping(value = "/createSubmit", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView createSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {

        ModelAndView response = new ModelAndView();
//        if ( form.getProductId() == null ) {
//            Product p = productDao.findByNameIgnoreCase(form.getProductName());
//
//            if ( p != null ) {
//                bindingResult.rejectValue("email", "email", "This email is already in use. Manual Check");
//            }
//        }


        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // TODO =  Cleanup this code to reduce the duplicated code in the create()
            response.addObject("bindingResult", bindingResult);

            loadDropdowns(response);


            response.setViewName("product/create");


            response.addObject("form", form);

            return response;
        } else {

            Product product = productService.createProduct(form);

            response.setViewName("redirect:/product/detail?productId=" + product.getId());

            return response;
        }
    }
}
