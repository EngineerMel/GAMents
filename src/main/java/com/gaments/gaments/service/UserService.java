package com.gaments.gaments.service;

import com.gaments.gaments.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    public User getUser(String username);
    public String createUser(User newUser);
    public String login(User returningUser);
    public List<User> listUsers();
    public User getUserData(String username);
}


