package com.gaments.gaments.controller;

import com.gaments.gaments.models.UserProfile;
import com.gaments.gaments.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    //create UserProfile
    @PostMapping("/profile/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile newUserProfile){
        return userProfileService.createUserProfile(username, newUserProfile);
    }

    //Get UserProfile of logged in User
    @GetMapping("/profile/{username}")
    public UserProfile getLoggedUserProfile(@PathVariable String username){
        return userProfileService.getLoggedUserProfile(username);
    }

    @GetMapping("/profile")
    public UserProfile getUserProfile(){
        return userProfileService.getUserProfile();
    }

    @PutMapping("/update")
    public UserProfile updateUserProfile(@RequestBody UserProfile updateUserProfile){
        return userProfileService.updateUserProfile(updateUserProfile);
    }

}
