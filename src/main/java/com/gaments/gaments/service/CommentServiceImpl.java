package com.gaments.gaments.service;


import com.gaments.gaments.config.AuthenticationImpl;
import com.gaments.gaments.models.Comment;
import com.gaments.gaments.models.Post;
import com.gaments.gaments.models.User;
import com.gaments.gaments.repository.CommentRepository;
import com.gaments.gaments.repository.PostRepository;
import com.gaments.gaments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationImpl authenticationImpl;

    @Override
    public Comment createCommentForLoggedUser(Comment newComment, Long postId, String username){
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findPostsById(postId);
        newComment.setUser(user);
        newComment.setPost(post);
        return commentRepository.save(newComment);
    }

    @Override
    public Comment createComment(Comment newComment, Long postId) {
        Authentication auth = authenticationImpl.getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        Post post = postRepository.findPostsById(postId);
        newComment.setUser(user);
        newComment.setPost(post);
        return commentRepository.save(newComment);
    }


    @Override
    public HttpStatus deleteComment(Long commentId) throws Exception{
        Long commentUserId = commentRepository.findById(commentId).orElseThrow(NullPointerException::new).getUser().getId();
        Authentication auth = authenticationImpl.getAuthentication();
        Long userId = userRepository.findByUsername(auth.getName()).getId();
        if (userId.equals(commentUserId)){
            commentRepository.deleteById(commentId);
            return HttpStatus.valueOf(200);
        }
        throw new IllegalAccessException();
    }

    @Override
    public List<Comment> listUsersComments(String username){
        User user = userRepository.findByUsername(username);
        return commentRepository.findCommentsByUser(user);
    }

    @Override
    public List<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> listPostComments(Long postId){
        Post post = postRepository.findPostsById(postId);
        return commentRepository.findCommentsByPost(post);
    }

}
