package com.example.capstone.store.security;

import com.example.capstone.store.database.dao.UserDAO;
import com.example.capstone.store.database.dao.UserRoleDAO;
import com.example.capstone.store.database.entity.User;
import com.example.capstone.store.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // fetch the user from the database - username is what the person entered into the username field on the login form
        // this User object is in the imports section
        User user = userDAO.findByEmailIgnoreCase(username);

        // if the user is null then what ever the person entered on the login form does not exist in the database
        // automatically throw an exception
        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // check the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // im using the user object from the database to get the user roles
        List<UserRole> userRoles = userRoleDAO.findByUserId(user.getId());
        // passing the user roles to create the granted authorities
        Collection<? extends GrantedAuthority> authorities = buildGrantAuthorities(userRoles);

        // this User object is part of Spring Security
        // because both objets are named User, we have to use the full path to the object
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),  // this paramter is the username, in our case the user from the database
                user.getPassword(), // this is the users encrypted password from the database
                accountIsEnabled, // is this account enabled, if false, then spring security will deny access
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities); // this is the list of security roles that the user is Authorized to have

        return userDetails;
    }

    // this is the process of looping through the user roles and creating the GrantedAuthorities
    // the GrantedAuthorities are what Spring Security uses to determine if a use
    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }


}
