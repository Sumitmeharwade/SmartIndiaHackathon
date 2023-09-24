package com.sih.springproject.service;


import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating addCustomer(Rating rating)
    {
        return ratingRepository.save(rating);
    }

    public Rating modifyCustomer(Rating rating)
    {
        return ratingRepository.save(rating);
    }

    public Rating deleteCustomer(Rating rating)
    {
        Rating ad=ratingRepository.findById(rating.getRatingId()).get();
        ratingRepository.delete(rating);
        return ad;
    }

    public Rating findCustomer(Long id)
    {
        return ratingRepository.findById(id).get();
    }

    public List<Rating> findAll()
    {
        return ratingRepository.findAll();
    }
}

