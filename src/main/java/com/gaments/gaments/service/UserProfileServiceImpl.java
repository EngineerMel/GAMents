//package com.gaments.gaments.service;
//
//import com.gaments.gaments.models.User;
//import com.gaments.gaments.models.UserProfile;
//import com.gaments.gaments.repository.UserProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.gaments.gaments.repository.UserRepository;
//
//@Service
//public class UserProfileServiceImpl implements UserProfileService {
//
//    @Autowired
//    UserProfileRepository userProfileRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    public UserProfileServiceImpl(UserService userService, UserProfileRepository userProfileRepository) {
//        this.userService = userService;
//        this.userProfileRepository = userProfileRepository;
//    }
//
//    @Override
//    public UserProfile createUserProfile(String username, UserProfile newProfile) {
//        User user = userService.getUser(username);
//        user.setUserProfile(newProfile);
//        return userService.createUser(user).getUserProfile();
//    }
//
//    @Override
//    public UserProfile getUserProfile(String username) {
//        return userProfileRepository.findProfileByUsername(username);
//    }
//
//    @Override
//    public UserProfile updateUserProfile(String username, UserProfile updatedProfile){
//        User user = userRepository.findByUsername(username);
//        UserProfile userProfile = user.getUserProfile();
//
//
//        if(updatedProfile.getEmail() != null){
//            userProfile.setEmail(updatedProfile.getEmail());
//        }
//        if(updatedProfile.getSkills() != null){
//            userProfile.setSkills(updatedProfile.getSkills());
//        }
//        if(updatedProfile.getOccupation() != null){
//            userProfile.setOccupation(updatedProfile.getOccupation());
//        }
//        if(updatedProfile.getCareerInterests() != null){
//            userProfile.setCareerInterests(updatedProfile.getCareerInterests());
//        }
//        if(updatedProfile.getHasMentor() != null){
//            userProfile.setHasMentor(updatedProfile.getHasMentor());
//        }
//        if(updatedProfile.getMentor() != null){
//            userProfile.setMentor(updatedProfile.getMentor());
//        }
//        return userProfileRepository.save(userProfile);
//
//    }
//
//
//}