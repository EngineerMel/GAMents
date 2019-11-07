package com.gaments.gaments.controller;

import com.gaments.gaments.models.Comment;
import com.gaments.gaments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    //Create Comment For User That is Logged In

    @PostMapping("/{postId}")
    public Comment createComment(@RequestBody Comment newComment, @PathVariable Long postId){
        return commentService.createComment(newComment, postId);
    }

    @PostMapping("/{postId}/{username}")
    public Comment createCommentForLoggedUser(@RequestBody Comment newComment, @PathVariable Long postId, @PathVariable String username){
        return commentService.createCommentForLoggedUser(newComment, postId, username);
    }


    //Delete A Comment
    @DeleteMapping("/delete/{commentId}")
    public HttpStatus deleteComment(@PathVariable Long commentId){
        try{
            return commentService.deleteComment(commentId);
        }
            //error handling for comment deletion
        catch (NullPointerException exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Comment Not Found", exc);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Attempted to Delete Another User's Comment", exc);
        }
    }

    //List Users Comments
    @GetMapping("/list/{username}")
    public List<Comment> listUsersComments(@PathVariable String username){
        return commentService.listUsersComments(username);
    }

    //List All Comments
    @GetMapping("/list")
    public List<Comment> listAllComments(){
        return commentService.listAllComments();
    }

    //List Comments Of A Post
    @GetMapping("/list/bypost/{postId}")
    public List<Comment> listPostComments(@PathVariable Long postId){
        return commentService.listPostComments(postId);
    }

}