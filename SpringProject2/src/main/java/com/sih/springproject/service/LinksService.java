package com.sih.springproject.service;


import com.sih.springproject.model.Links;
import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.LinksRepository;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinksService {
    @Autowired
    private LinksRepository linksRepository;

    public Links addCustomer(Links links)
    {
        return linksRepository.save(links);
    }

    public Links modifyCustomer(Links links)
    {
        return linksRepository.save(links);
    }

    public Links deleteCustomer(Links links)
    {
        Links ad=linksRepository.findById(links.getLinkId()).get();
        linksRepository.delete(links);
        return ad;
    }

    public Links findCustomer(Long id)
    {
        return linksRepository.findById(id).get();
    }

    public List<Links> findAll()
    {
        return linksRepository.findAll();
    }
}

