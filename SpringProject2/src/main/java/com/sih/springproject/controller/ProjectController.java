package com.sih.springproject.controller;

import com.sih.springproject.model.Project;
import com.sih.springproject.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Project")

public class ProjectController {

    ProjectService projectService;

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project)
    {
        return projectService.addProject(project);
    }
}
