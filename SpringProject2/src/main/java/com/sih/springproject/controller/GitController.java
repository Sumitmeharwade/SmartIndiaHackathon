package com.sih.springproject.controller;


import com.sih.springproject.model.Comment;
import com.sih.springproject.model.Git;
import com.sih.springproject.service.CommentService;
import com.sih.springproject.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Git")

public class GitController {

    @Autowired
    GitService gitService;

    @PostMapping("/add")
    public Git addGit(@RequestBody Git git)
    {
        return gitService.addGit(git);
    }
    @GetMapping("/get/{gitId}")
    public Git getGitById(@PathVariable Long gitId)
    {
        return gitService.findGit(gitId);
    }
    @GetMapping("/getall")
    public List<Git> getAllGit(){
        return gitService.findAll();
    }
}
