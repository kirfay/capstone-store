package com.example.capstone.store.service;

import com.example.capstone.store.database.dao.ProductDAO;
import com.example.capstone.store.database.entity.Product;
import com.example.capstone.store.form.CreateProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductService {

    @Autowired
    private ProductDAO productDao;



    public Product createProduct(CreateProductFormBean form) {
        // log out the incoming variables that are in the CreateEmployeeFormBean
        log.debug(form.toString());

        // first, I am going to take a shot at looking up the record in the database based on the incoming employeeId
        // this is from the hidden input field and is not something the user actually entered themselves
        Product product = productDao.findById(form.getProductId());
        if ( product == null ) {
            /// this means it was not found in the database so we are going to consider this a create
            product = new Product();
        }

        // here we are setting the values from the inoming form data onto the database entity
        product.setName(form.getProductName());
        product.setPrice(form.getProductPrice());
        product.setImageUrl(form.getProductImageUrl());
        product.setDescription(form.getProductDescription());


        // when we save to the data base it will auto increment to give us a new id
        // the new ID is available in the return from the save method.
        // basically returns the same object .. after its been inserted into the database

        product = productDao.save(product);
        return product;
    }
}