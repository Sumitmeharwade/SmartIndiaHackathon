package com.sih.springproject.service;


import com.sih.springproject.model.Comment;
import com.sih.springproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addCustomer(Comment comment)
    {
        return commentRepository.save(comment);
    }

    public Comment modifyCustomer(Comment comment)
    {
        return commentRepository.save(comment);
    }

    public Comment deleteCustomer(Comment comment)
    {
        Comment ad=commentRepository.findById(comment.getCommentId()).get();
        commentRepository.delete(comment);
        return ad;
    }

    public Comment findCustomer(Long id)
    {
        return commentRepository.findById(id).get();
    }

    public List<Comment> findAll()
    {
        return commentRepository.findAll();
    }
}
