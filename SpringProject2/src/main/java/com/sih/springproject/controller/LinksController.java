package com.sih.springproject.controller;


import com.sih.springproject.model.Comment;
import com.sih.springproject.model.Links;
import com.sih.springproject.service.CommentService;
import com.sih.springproject.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Links")

public class LinksController {

    @Autowired
    LinksService linksService;

    @PostMapping("/add")
    public Links addLinks(@RequestBody Links links)
    {
        return linksService.addLinks(links);
    }
    @GetMapping("/get/{linksId}")
    public Links getLinksById(@PathVariable Long linksId)
    {
        return linksService.findLinks(linksId);
    }
    @GetMapping("/getall")
    public List<Links> getAllLinks(){
        return linksService.findAll();
    }
}
