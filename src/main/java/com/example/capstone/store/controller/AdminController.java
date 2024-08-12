package com.example.capstone.store.controller;

import com.example.capstone.store.database.dao.ProductDAO;
import com.example.capstone.store.database.entity.Product;
import com.example.capstone.store.database.entity.User;
import com.example.capstone.store.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;
    @Autowired
    private ProductDAO productDao;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() throws Exception {
        ModelAndView response = new ModelAndView("admin/dashboard");

        List<Product> products = productDao.findAll(); // Updated to List<Product>

        response.addObject("products", products);
        User user = authenticatedUserUtilities.getCurrentUser();
        log.debug(user.toString());

        return response;
    }
}