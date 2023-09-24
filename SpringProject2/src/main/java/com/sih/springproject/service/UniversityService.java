package com.sih.springproject.service;


import com.sih.springproject.model.Rating;
import com.sih.springproject.model.University;
import com.sih.springproject.repository.RatingRepository;
import com.sih.springproject.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public University addCustomer(University university)
    {
        return universityRepository.save(university);
    }

    public University modifyCustomer(University university)
    {
        return universityRepository.save(university);
    }

    public University deleteCustomer(University university)
    {
        University ad=universityRepository.findById(university.getUserId()).get();
        universityRepository.delete(university);
        return ad;
    }

    public University findCustomer(Long id)
    {
        return universityRepository.findById(id).get();
    }

    public List<University> findAll()
    {
        return universityRepository.findAll();
    }
}

