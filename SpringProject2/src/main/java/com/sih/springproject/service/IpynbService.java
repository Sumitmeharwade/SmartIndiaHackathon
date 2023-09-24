package com.sih.springproject.service;


import com.sih.springproject.model.Ipynb;
import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.IpynbRepository;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpynbService {
    @Autowired
    private IpynbRepository ipynbRepository;

    public Ipynb addCustomer(Ipynb ipynb)
    {
        return ipynbRepository.save(ipynb);
    }

    public Ipynb modifyCustomer(Ipynb ipynb)
    {
        return ipynbRepository.save(ipynb);
    }

    public Ipynb deleteCustomer(Ipynb ipynb)
    {
        Ipynb ad=ipynbRepository.findById(ipynb.getIpynbId()).get();
        ipynbRepository.delete(ipynb);
        return ad;
    }

    public Ipynb findCustomer(Long id)
    {
        return ipynbRepository.findById(id).get();
    }

    public List<Ipynb> findAll()
    {
        return ipynbRepository.findAll();
    }
}

