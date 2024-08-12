package com.example.capstone.store.service;

import com.example.capstone.store.database.dao.UserDAO;
import com.example.capstone.store.database.dao.UserRoleDAO;
import com.example.capstone.store.database.entity.User;
import com.example.capstone.store.database.entity.UserRole;
import com.example.capstone.store.form.CreateAccountFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User createUser(CreateAccountFormBean form) {
        // there were no errors so we can create the new user in the database
        User user = new User();

        // encrypt the password before saving it to the database
        user.setEmail(form.getEmail());

        // we are getting in a plain text password because the user entered it into the form
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        user.setCreateDate(new Date());

        // save the user to the database
        userDAO.save(user);

        // create a user role for the user
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());

        userRoleDAO.save(userRole);

        return user;
    }

}
