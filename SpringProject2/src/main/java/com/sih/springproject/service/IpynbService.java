package com.sih.springproject.service;


import com.sih.springproject.model.Ipynb;

import com.sih.springproject.repository.IpynbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpynbService {
    @Autowired
    private IpynbRepository ipynbRepository;

    public Ipynb addIpynb(Ipynb ipynb)
    {
        return ipynbRepository.save(ipynb);
    }

    public Ipynb modifyIpynb(Ipynb ipynb)
    {
        return ipynbRepository.save(ipynb);
    }

    public Ipynb deleteIpynb(Ipynb ipynb)
    {
        Ipynb ad=ipynbRepository.findById(ipynb.getIpynbId()).get();
        ipynbRepository.delete(ipynb);
        return ad;
    }

    public Ipynb findIpynb(Long id)
    {
        return ipynbRepository.findById(id).get();
    }

    public List<Ipynb> findAll()
    {
        return ipynbRepository.findAll();
    }
}

