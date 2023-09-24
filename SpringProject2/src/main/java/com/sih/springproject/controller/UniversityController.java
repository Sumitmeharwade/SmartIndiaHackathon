package com.sih.springproject.controller;


import com.sih.springproject.model.University;
import com.sih.springproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/University")

public class UniversityController {

    @Autowired
    UniversityService universityService;

    @PostMapping("/add")
    public University addUniversity(@RequestBody University university)
    {
        return universityService.addUniversity(university);
    }
    @GetMapping("/get/{universityId}")
    public University getUniversityById(@PathVariable Long universityId)
    {
        return universityService.findUniversity(universityId);
    }
    @GetMapping("/getall")
    public List<University> getAllUniversity(){
        return universityService.findAll();
    }
}
