package com.sih.springproject.service;


import com.sih.springproject.model.Qualification;
import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.QualificationRepository;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    public Qualification addCustomer(Qualification qualification)
    {
        return qualificationRepository.save(qualification);
    }

    public Qualification modifyCustomer(Qualification qualification)
    {
        return qualificationRepository.save(qualification);
    }

    public Qualification deleteCustomer(Qualification qualification)
    {
        Qualification ad=qualificationRepository.findById(qualification.getQualificationId()).get();
        qualificationRepository.delete(qualification);
        return ad;
    }

    public Qualification findCustomer(Long id)
    {
        return qualificationRepository.findById(id).get();
    }

    public List<Qualification> findAll()
    {
        return qualificationRepository.findAll();
    }
}

