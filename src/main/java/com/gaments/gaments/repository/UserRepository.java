package com.gaments.gaments.repository;

import com.gaments.gaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u WHERE u.username = ?1 and u.password = ?2")
    public User login(String username, String password);
}
