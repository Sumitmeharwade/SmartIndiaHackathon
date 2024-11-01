package com.sih.springproject.service;


import com.sih.springproject.model.University;
import com.sih.springproject.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public University addUniversity(University university)
    {
        return universityRepository.save(university);
    }

    public University modifyUniversity(University university)
    {
        return universityRepository.save(university);
    }

    public University deleteUniversity(University university)
    {
        University ad=universityRepository.findById(university.getUserId()).get();
        universityRepository.delete(university);
        return ad;
    }

    public University findUniversity(Long id)
    {
        return universityRepository.findById(id).get();
    }

    public List<University> findAll()
    {
        return universityRepository.findAll();
    }
}

