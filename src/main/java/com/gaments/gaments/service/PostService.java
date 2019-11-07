package com.gaments.gaments.service;

import com.gaments.gaments.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PostService {

    //create post
    Post createPost(Post newPost);

    //list users post
    List<Post> listUsersPost(String username);

    //list all posts
    List<Post> listAllPosts();

    //delete post by id
    HttpStatus deleteById(Long postId) throws Exception;

    //list only a logged in User's posts
    List<Post> listLoggedPosts();

}