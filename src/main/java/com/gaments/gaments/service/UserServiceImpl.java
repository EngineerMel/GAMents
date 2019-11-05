package com.gaments.gaments.service;

import com.gaments.gaments.models.User;
import com.gaments.gaments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    @Override
    public User login(String username, String password){
        return userRepository.login(username, password);
    }

    @Override
    public HttpStatus deleteUser(long id){
        userRepository.deleteById(id);
        return HttpStatus.OK;

    }
}
