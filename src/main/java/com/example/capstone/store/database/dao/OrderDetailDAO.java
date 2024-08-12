package com.example.capstone.store.database.dao;

import com.example.capstone.store.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "select * from orderdetail where order_id = :orderId and product_id = :productId", nativeQuery = true)
    OrderDetail isProductInCart(Integer orderId, Integer productId);
}
