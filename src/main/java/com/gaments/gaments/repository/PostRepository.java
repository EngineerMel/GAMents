package com.gaments.gaments.repository;

import com.gaments.gaments.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}