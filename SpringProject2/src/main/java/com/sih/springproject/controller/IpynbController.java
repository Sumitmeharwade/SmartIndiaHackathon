package com.sih.springproject.controller;


import com.sih.springproject.model.Comment;
import com.sih.springproject.model.Ipynb;
import com.sih.springproject.service.CommentService;
import com.sih.springproject.service.IpynbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Ipynb")

public class IpynbController {

    @Autowired
    IpynbService ipynbService;

    @PostMapping("/add")
    public Ipynb addIpynb(@RequestBody Ipynb ipynb)
    {
        return ipynbService.addIpynb(ipynb);
    }
    @GetMapping("/get/{ipynbId}")
    public Ipynb getIpynbById(@PathVariable Long ipynbId)
    {
        return ipynbService.findIpynb(ipynbId);
    }
    @GetMapping("/getall")
    public List<Ipynb> getAllIpynb(){
        return ipynbService.findAll();
    }
}
