package com.gaments.gaments.controller;

import com.gaments.gaments.config.JwtResponse;
import com.gaments.gaments.models.User;
import com.gaments.gaments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public ResponseEntity<?> login(@RequestBody User returningUser, HttpServletRequest request, HttpSession session){
        return ResponseEntity.ok(new JwtResponse(userService.login(returningUser, request, session)));
    }

    @GetMapping("/list-users")
    public List<User> listUsers(){
        return userService.listUsers();
    }



}
