package com.gaments.gaments.service;

import com.gaments.gaments.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PostService {

    Post createPost(Post newPost, String username);

    List<Post> listUsersPost(String username);

    List<Post> listPosts();

    HttpStatus deleteById(Long postId);

}