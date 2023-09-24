package com.sih.springproject.service;


import com.sih.springproject.model.Qualification;
import com.sih.springproject.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    public Qualification addQualification(Qualification qualification)
    {
        return qualificationRepository.save(qualification);
    }

    public Qualification modifyQualification(Qualification qualification)
    {
        return qualificationRepository.save(qualification);
    }

    public Qualification deleteQualification(Qualification qualification)
    {
        Qualification ad=qualificationRepository.findById(qualification.getQualificationId()).get();
        qualificationRepository.delete(qualification);
        return ad;
    }

    public Qualification findQualification(Long id)
    {
        return qualificationRepository.findById(id).get();
    }

    public List<Qualification> findAll()
    {
        return qualificationRepository.findAll();
    }
}

