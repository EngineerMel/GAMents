package com.gaments.gaments.controller;

import com.gaments.gaments.models.Post;
import com.gaments.gaments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post newPost){
        return postService.createPost(newPost);
    }

    @DeleteMapping("/post/{id}")
    public HttpStatus deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }
}
