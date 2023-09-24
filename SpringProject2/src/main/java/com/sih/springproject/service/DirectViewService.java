package com.sih.springproject.service;


import com.sih.springproject.model.DirectView;
import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.DirectViewRepository;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectViewService {
    @Autowired
    private DirectViewRepository directViewRepository;

    public DirectView addCustomer(DirectView directView)
    {
        return directViewRepository.save(directView);
    }

    public DirectView modifyCustomer(DirectView directView)
    {
        return directViewRepository.save(directView);
    }

    public DirectView deleteCustomer(DirectView directView)
    {
        DirectView ad=directViewRepository.findById(directView.getDirectViewID()).get();
        directViewRepository.delete(directView);
        return ad;
    }

    public DirectView findCustomer(Long id)
    {
        return directViewRepository.findById(id).get();
    }

    public List<DirectView> findAll()
    {
        return directViewRepository.findAll();
    }
}
