package com.gaments.gaments.service;

import com.gaments.gaments.models.UserProfile;

public interface UserProfileService {

    public UserProfile createUserProfile(String username, UserProfile newUserProfile);
    public UserProfile getLoggedUserProfile(String username);
    public UserProfile getUserProfile();
    public UserProfile updateUserProfile(String username, UserProfile updatedUserProfile);
}
