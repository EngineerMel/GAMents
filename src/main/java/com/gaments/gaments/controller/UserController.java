package com.gaments.gaments.controller;

import com.gaments.gaments.config.JwtResponse;
import com.gaments.gaments.models.User;
import com.gaments.gaments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        try {
            return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.IM_USED, "Username already exists", exc);
        }
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
