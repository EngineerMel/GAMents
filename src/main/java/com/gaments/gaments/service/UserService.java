package com.gaments.gaments.service;

import com.gaments.gaments.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface UserService extends UserDetailsService {

    public User getUser(String username);
    public String createUser(User newUser);
    public String login(User returningUser, HttpServletRequest request, HttpSession session);
    public List<User> listUsers();
}


