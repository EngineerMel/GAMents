package com.gaments.gaments.controller;

import com.gaments.gaments.models.Post;
import com.gaments.gaments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    //creates a post
    @PostMapping
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);
    }

    //list the Users posts
    @GetMapping("/list-posts/{username}")
    public List<Post> listUsersPost(@PathVariable String username) {
        return postService.listUsersPost(username);
    }

    //list all posts
    @GetMapping("/list-all")
    public List<Post> listAllPosts() {
        return postService.listAllPosts();
    }

    //list a logged in user's posts
    @GetMapping("/list-logged")
    public List<Post> listLoggedPosts() {
        return postService.listLoggedPosts();
    }

    //deletes a post by the postId
    @DeleteMapping("/delete/{postId}")
    public HttpStatus deletePostById(@PathVariable Long postId) {
        try {
            return postService.deleteById(postId);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Attempt to Delete Other User's Posts", exc);

        }
    }
}