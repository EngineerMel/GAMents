package com.gaments.gaments.service;

import com.gaments.gaments.models.Comment;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CommentService {

    public Comment createCommentForLoggedUser(Comment newComment, Long postId, String username);
    public Comment createComment(Comment newComment, Long postId);
    public HttpStatus deleteComment(Long commentId) throws Exception;
    public List<Comment> listUsersComments(String username);
    public List<Comment> listAllComments();
    public List<Comment> listPostComments(Long postId);
}
