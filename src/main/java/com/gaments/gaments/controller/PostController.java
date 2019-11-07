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

    @PostMapping("/post/{username}")
    public Post createPost (@RequestBody Post newPost, @PathVariable String username){
        return postService.createPost(newPost, username);
    }

    @GetMapping("/list-posts/{username}")
    public List<Post> listUsersPost(@PathVariable String username){
        return postService.listUsersPost(username);
    }

    @GetMapping("/list-posts")
    public List<Post> listPosts(){
        return postService.listPosts();
    }

    @DeleteMapping("/post/delete/{postId}")
    public HttpStatus deletePostById (@PathVariable Long postId){
        return postService.deleteById(postId);
    }



}
