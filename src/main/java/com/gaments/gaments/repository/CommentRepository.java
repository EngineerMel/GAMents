package com.gaments.gaments.repository;

import com.gaments.gaments.models.Comment;
import com.gaments.gaments.models.Post;
import com.gaments.gaments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByUser(User user);
    List<Comment> findCommentsByPost(Post post);
}
