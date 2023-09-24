package com.sih.springproject.controller;


import com.sih.springproject.model.Project;
import com.sih.springproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Project")

public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project)
    {
        return projectService.addProject(project);
    }
    @GetMapping("/get/{projectId}")
    public Project getProjectById(@PathVariable Long projectId)
    {
        return projectService.findProject(projectId);
    }
    @GetMapping("/getall")
    public List<Project> getAllProject(){
        return projectService.findAll();
    }
}
