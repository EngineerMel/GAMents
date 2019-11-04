package com.gaments.gaments.repository;

import com.gaments.gaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
