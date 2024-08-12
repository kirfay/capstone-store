package com.example.capstone.store.controller;

import com.example.capstone.store.database.dao.ProductDAO;
import com.example.capstone.store.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ProductDAO productDao;


    @GetMapping("/" )
    public ModelAndView index(@RequestParam(required = false) Integer id) {

        ModelAndView response = new ModelAndView("index");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        log.debug("debug level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");

        response.addObject("message", "Hello World!");
        return response;



    }


    @GetMapping("/admin" )

    public ModelAndView admin(@RequestParam(required = false) Integer id) {

        ModelAndView response = new ModelAndView("admin");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        log.debug("debug level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");

        response.addObject("message", "Hello World!");
        return response;



    }

    @GetMapping("/single-product" )

    public ModelAndView singleProduct(@RequestParam(required = false) Integer id) {

        ModelAndView response = new ModelAndView("single-product");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);



        response.addObject("message", "Hello World!");
        return response;



    }


    @GetMapping("/order-details" )

    public ModelAndView orderDetails(@RequestParam(required = false) Integer id) {

        // this function is for the home page of the website which is express as just a plain slash "/"
        ModelAndView response = new ModelAndView("order-details");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);



        response.addObject("message", "Hello World!");
        return response;



    }

    @GetMapping("/admin-order-details" )

    public ModelAndView adminOrderDetails(@RequestParam(required = false) Integer id) {

        // this function is for the home page of the website which is express as just a plain slash "/"
        ModelAndView response = new ModelAndView("admin-order-details");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);



        response.addObject("message", "Hello World!");
        return response;



    }


    @GetMapping("/create-update" )

    public ModelAndView createUpdate(@RequestParam(required = false) Integer id) {

        ModelAndView response = new ModelAndView("create-update");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        //response.addObject("message", "Hello World!");
        return response;



    }



    @GetMapping("/{id}" )

    public ModelAndView indexPathVar(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("index");
        Product product = productDao.findById(id);
        response.addObject("productKey", product);
        response.addObject("message", "Hello World!");
        return response;

    }


    @GetMapping("/all-products")

    public ModelAndView allProducts() {

        ModelAndView response = new ModelAndView("all-products");
        return response;

    }



    @GetMapping("/login")

    public ModelAndView login() {

        ModelAndView response = new ModelAndView("login");
        return response;

    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {

        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search);

        response.addObject("search", search);


        List<Product> products = productDao.findByName(search);
        products.stream().forEach(product -> {
            log.debug("Product: " + product.getName());
        });

        if (search == null || search.trim().isEmpty()) {
            products = productDao.findAll();
        } else {
            products = productDao.findByName(search);
        }


        response.addObject("products", products);

        return response;
    }

}