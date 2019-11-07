package com.gaments.gaments.repository;

import com.gaments.gaments.models.Post;
import com.gaments.gaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUser(User user);
    Post findPostsById(Long postId);

}
