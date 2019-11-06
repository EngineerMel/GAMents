package com.gaments.gaments.controller;

import com.gaments.gaments.config.JwtResponse;
import com.gaments.gaments.models.User;
import com.gaments.gaments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User returningUser){
        return ResponseEntity.ok(new JwtResponse(userService.login(returningUser)));
    }

    @GetMapping("/list-users")
    public List<User> listUsers(){
        return userService.listUsers();
    }

}
