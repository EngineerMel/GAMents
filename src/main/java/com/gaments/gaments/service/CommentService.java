package com.gaments.gaments.service;

import com.gaments.gaments.models.Comment;
import org.springframework.http.HttpStatus;

public interface CommentService {

    public Comment createComment(Comment newComment);
    public HttpStatus deleteComment(Long commentId);
}
