package com.gaments.gaments.controller;

import com.gaments.gaments.models.Post;
import com.gaments.gaments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

        //creates a post
    @PostMapping("/post")
    public Post createPost (@RequestBody Post newPost){
        return postService.createPost(newPost);
    }

        //list the User's posts
    @GetMapping("/list-posts/{username}")
    public List<Post> listUsersPost(@PathVariable String username){
        return postService.listUsersPost(username);
    }

        //list all posts
    @GetMapping("/all-posts")
    public List<Post> listAllPosts(){
        return postService.listAllPosts();
    }

    //list a logged in user's posts
    @GetMapping("/list-logged/posts")
    public List<Post> listLoggedPosts(){
        return postService.listLoggedPosts();
    }

        //deletes a post by the postId
    @DeleteMapping("/post/delete/{postId}")
    public HttpStatus deletePostById (@PathVariable Long postId){
        return postService.deleteById(postId);
    }

}