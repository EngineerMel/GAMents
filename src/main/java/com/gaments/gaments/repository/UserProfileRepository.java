package com.gaments.gaments.repository;

import com.gaments.gaments.models.User;
import com.gaments.gaments.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findUserProfilesByUser(User user);

}
