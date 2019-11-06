package com.gaments.gaments.service;

import com.gaments.gaments.config.JwtUtil;
import com.gaments.gaments.models.User;
import com.gaments.gaments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if (user == null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
//        @Override
//        public List<User> listUsers () {
//            return userRepository.findAll();
//        }
//
//        @Override
//        public User createUser (User newUser){
//            return userRepository.save(newUser);
//        }
//
//        @Override
//        public User login (String username, String password){
//            return userRepository.login(username, password);
//        }
//
//        @Override
//        public HttpStatus deleteUser ( long id){
//            userRepository.deleteById(id);
//            return HttpStatus.OK;
//        }

        @Override
        public User getUser (String username){
            return userRepository.findByUsername(username);
        }
    }
