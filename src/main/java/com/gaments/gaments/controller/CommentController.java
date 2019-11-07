package com.gaments.gaments.controller;

import com.gaments.gaments.models.Comment;
import com.gaments.gaments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    //Create Comment
    @PostMapping("/comment/{postId}/{username}")
    public Comment createComment(@RequestBody Comment newComment, @PathVariable Long postId, @PathVariable String username){
        return commentService.createComment(newComment, postId, username);
    }

    //Delete A Comment
    @DeleteMapping("/comment/delete/{commentId}")
    public HttpStatus deleteComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId);
    }

    //List Users Comments
    @GetMapping("/comment/list/{username}")
    public List<Comment> listUsersComments(@PathVariable String username){
        return commentService.listUsersComments(username);
    }
    //List All Comments
    @GetMapping("/comment/list")
    public List<Comment> listAllComments(){
        return commentService.listAllComments();
    }
    //List Comments Of A Post
    @GetMapping("/comment/list/bypost/{postId}")
    public List<Comment> listPostComments(@PathVariable Long postId){
        return commentService.listPostComments(postId);
    }

}