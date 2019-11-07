package com.gaments.gaments.service;


import com.gaments.gaments.models.Comment;
import com.gaments.gaments.models.Post;
import com.gaments.gaments.models.User;
import com.gaments.gaments.repository.CommentRepository;
import com.gaments.gaments.repository.PostRepository;
import com.gaments.gaments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Comment createComment(Comment newComment, Long postId, String username){
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findPostsById(postId);
        newComment.setUser(user);
        newComment.setPost(post);
        return commentRepository.save(newComment);
    }

    @Override
     public HttpStatus deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
        return HttpStatus.valueOf(200);
    }
}
