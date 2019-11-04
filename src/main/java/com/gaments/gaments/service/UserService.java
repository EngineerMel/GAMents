package com.gaments.gaments.service;

import com.gaments.gaments.models.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();
    public User createUser(User newUser);


}

