package com.example.capstone.store.database.dao;

import com.example.capstone.store.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {


    List<UserRole> findByUserId(Integer userId);

}