package com.example.capstone.store.database.dao;

import com.example.capstone.store.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {


    User findByEmailIgnoreCase(String email);

}