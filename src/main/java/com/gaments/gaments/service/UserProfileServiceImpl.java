package com.gaments.gaments.service;

import com.gaments.gaments.models.User;
import com.gaments.gaments.models.UserProfile;
import com.gaments.gaments.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserService userService;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile){
        User user = userService.getUser(username);
        user.setUserProfile(newProfile);
        return userService.createUser(user).getUserProfile();
    }

    @Override
    public UserProfile getUserProfile(String username){
        return userProfileRepository.findProfileByUsername(username);
    }
}
