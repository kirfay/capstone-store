package com.example.capstone.store.database.dao;


import com.example.capstone.store.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductDAO extends JpaRepository<Product, Long> {

    Product findById(Integer id);

    @Query("select p from Product p where p.name like concat('%', :name, '%')")
    List<Product> findByName (String name);

    Product findByNameIgnoreCase(String name);


}
