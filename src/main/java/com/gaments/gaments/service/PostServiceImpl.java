package com.gaments.gaments.service;

import com.gaments.gaments.models.Post;
import com.gaments.gaments.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post newPost) {
        return null;
    }

    @Override
    public HttpStatus deletePost(Long id) {
        return null;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return null;
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }
}
