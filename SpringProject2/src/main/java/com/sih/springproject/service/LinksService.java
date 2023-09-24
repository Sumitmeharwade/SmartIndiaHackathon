package com.sih.springproject.service;


import com.sih.springproject.model.Links;

import com.sih.springproject.repository.LinksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinksService {
    @Autowired
    private LinksRepository linksRepository;

    public Links addLinks(Links links)
    {
        return linksRepository.save(links);
    }

    public Links modifyLinks(Links links)
    {
        return linksRepository.save(links);
    }

    public Links deleteLinks(Links links)
    {
        Links ad=linksRepository.findById(links.getLinkId()).get();
        linksRepository.delete(links);
        return ad;
    }

    public Links findLinks(Long id)
    {
        return linksRepository.findById(id).get();
    }

    public List<Links> findAll()
    {
        return linksRepository.findAll();
    }
}

