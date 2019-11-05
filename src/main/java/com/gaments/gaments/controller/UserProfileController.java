package com.gaments.gaments.controller;

import com.gaments.gaments.models.UserProfile;
import com.gaments.gaments.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username){
        return userProfileService.getUserProfile(username);
    }

    @PostMapping("/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile userProfile){
        return userProfileService.createUserProfile(username, userProfile);
    }

   @PutMapping("/update/{username}")
   public UserProfile updateUserProfile(@PathVariable String username, @RequestBody UserProfile updatedProfile){
        return userProfileService.updateUserProfile(username, updatedProfile);
   }

}
