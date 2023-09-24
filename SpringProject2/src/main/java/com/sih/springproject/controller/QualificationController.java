package com.sih.springproject.controller;


import com.sih.springproject.model.Qualification;
import com.sih.springproject.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Qualification")

public class QualificationController {

    @Autowired
    QualificationService qualificationService;

    @PostMapping("/add")
    public Qualification addQualification(@RequestBody Qualification qualification)
    {
        return qualificationService.addQualification(qualification);
    }
    @GetMapping("/get/{qualificationId}")
    public Qualification getQualificationById(@PathVariable Long qualificationId)
    {
        return qualificationService.findQualification(qualificationId);
    }
    @GetMapping("/getall")
    public List<Qualification> getAllQualification(){
        return qualificationService.findAll();
    }
}
