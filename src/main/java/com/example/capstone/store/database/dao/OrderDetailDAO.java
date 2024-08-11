package com.example.capstone.store.database.dao;

import com.example.capstone.store.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

}
