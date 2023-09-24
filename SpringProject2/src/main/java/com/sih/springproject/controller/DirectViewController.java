package com.sih.springproject.controller;


import com.sih.springproject.model.DirectView;
import com.sih.springproject.service.DirectViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/DirectView")

public class DirectViewController {

    @Autowired
    DirectViewService directViewService;

    @PostMapping("/add")
    public DirectView adddirectView(@RequestBody DirectView project)
    {
        return directViewService.addDirectView(project);
    }
    @GetMapping("/get/{directViewId}")
    public DirectView getDirectViewById(@PathVariable Long directViewId)
    {
        return directViewService.findDirectView(directViewId);
    }
    @GetMapping("/getall")
    public List<DirectView> getAllDirectView(){
        return directViewService.findAll();
    }
}
