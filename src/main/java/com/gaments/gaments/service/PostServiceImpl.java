package com.gaments.gaments.service;

import com.gaments.gaments.config.AuthenticationImpl;
import com.gaments.gaments.models.Post;
import com.gaments.gaments.models.User;
import com.gaments.gaments.repository.PostRepository;
import com.gaments.gaments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationImpl authenticationImpl;

    @Override
    public Post createPost(Post newPost){
        Authentication auth = authenticationImpl.getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    @Override
    public List<Post> listPosts(){
        return postRepository.findAll();
    }

    @Override
    public List<Post> listUsersPost(String username){
        User user = userRepository.findByUsername(username);
        return postRepository.findPostsByUser(user);
    }

    @Override
    public HttpStatus deleteById(Long postId){
        postRepository.deleteById(postId);
        return HttpStatus.OK;
    }
}
