package com.gaments.gaments.service;

import com.gaments.gaments.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> listUsers();
    public User createUser(User newUser);
    public User login(String username, String password);
    public HttpStatus deleteUser(long id);
    public User getUser(String username);


//    UserDetails loadUserByUsername(String username);
}

