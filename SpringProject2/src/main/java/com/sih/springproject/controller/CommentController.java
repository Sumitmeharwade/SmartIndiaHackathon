package com.sih.springproject.controller;


import com.sih.springproject.model.Comment;
import com.sih.springproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Comment")

public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    public Comment addProject(@RequestBody Comment comment)
    {
        return commentService.addComment(comment);
    }
    @GetMapping("/get/{commentId}")
    public Comment getCustomerById(@PathVariable Long commentId)
    {
        return commentService.findComment(commentId);
    }
    @GetMapping("/getall")
    public List<Comment> getAllCustomer(){
        return commentService.findAll();
    }
}
