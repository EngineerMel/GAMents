package com.gaments.gaments.controller;

import com.gaments.gaments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;
}
