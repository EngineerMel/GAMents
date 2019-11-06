package com.gaments.gaments.service;


import com.gaments.gaments.models.Comment;
import com.gaments.gaments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment newComment){
        return commentRepository.save(newComment);
    }

    @Override
     public HttpStatus deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
        return HttpStatus.valueOf(200);
    }
}
