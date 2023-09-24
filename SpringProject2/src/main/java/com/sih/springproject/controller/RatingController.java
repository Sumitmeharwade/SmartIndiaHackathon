package com.sih.springproject.controller;


import com.sih.springproject.model.Comment;
import com.sih.springproject.model.Rating;
import com.sih.springproject.service.CommentService;
import com.sih.springproject.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Rating")

public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/add")
    public Rating addRating(@RequestBody Rating rating)
    {
        return ratingService.addRating(rating);
    }
    @GetMapping("/get/{ratingId}")
    public Rating getRatingById(@PathVariable Long ratingId)
    {
        return ratingService.findRating(ratingId);
    }
    @GetMapping("/getall")
    public List<Rating> getAllRating(){
        return ratingService.findAll();
    }
}
