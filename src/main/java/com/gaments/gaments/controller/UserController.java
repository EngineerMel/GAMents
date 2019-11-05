package com.gaments.gaments.controller;

import com.gaments.gaments.models.User;
import com.gaments.gaments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list-users")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password){
        return userService.login(username, password);
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus deleteUserById(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
