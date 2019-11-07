package com.gaments.gaments.service;

import com.gaments.gaments.config.AuthenticationImpl;
import com.gaments.gaments.models.User;
import com.gaments.gaments.models.UserProfile;
import com.gaments.gaments.repository.UserProfileRepository;
import com.gaments.gaments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationImpl authenticationImpl;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newUserProfile){
        User user = userRepository.findByUsername(username);
        newUserProfile.setUser(user);
        user.setUserProfile(newUserProfile);
        userProfileRepository.save(newUserProfile);
        return user.getUserProfile();
    }

    @Override
    public UserProfile getLoggedUserProfile(String username){
        User user = userRepository.findByUsername(username);
        return user.getUserProfile();
    }

    @Override
    public UserProfile getUserProfile() {
        Authentication auth = authenticationImpl.getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        return user.getUserProfile();
    }


    @Override
    public UserProfile updateUserProfile(String username, UserProfile updatedUserProfile){
        User user = userRepository.findByUsername(username);
        UserProfile userProfile = user.getUserProfile();
        if(updatedUserProfile.getSkills() != null){
            userProfile.setSkills(updatedUserProfile.getSkills());
        }

        if(updatedUserProfile.getOccupation() != null){
            userProfile.setOccupation(updatedUserProfile.getOccupation());
        }

        if(updatedUserProfile.getEmail() != null){
            userProfile.setEmail(updatedUserProfile.getEmail());
        }

        if(updatedUserProfile.getCareerInterests() != null){
            userProfile.setCareerInterests(updatedUserProfile.getCareerInterests());
        }

        if(updatedUserProfile.getHasMentor() != null){
            userProfile.setHasMentor(updatedUserProfile.getHasMentor());
        }

        if(updatedUserProfile.getMentor() != null){
            userProfile.setMentor(updatedUserProfile.getMentor());
        }

        return userProfileRepository.save(userProfile);

    }
}
