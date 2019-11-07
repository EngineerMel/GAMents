package com.gaments.gaments.service;

import com.gaments.gaments.models.Comment;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CommentService {

    public Comment createComment(Comment newComment, Long postId, String username);
    public HttpStatus deleteComment(Long commentId);
    public List<Comment> listUsersComments(String username);
}
