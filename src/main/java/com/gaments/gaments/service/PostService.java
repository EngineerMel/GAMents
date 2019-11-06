package com.gaments.gaments.service;

import com.gaments.gaments.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public Post createPost(Post newPost);

    public HttpStatus deletePost(Long id);

    public Iterable<Post> listAllPosts();

    public Post getPostById(Long id);

}
