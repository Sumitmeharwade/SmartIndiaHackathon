package com.sih.springproject.controller;

import com.sih.springproject.model.Project;
import com.sih.springproject.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/Project")

public class ProjectController {

    ProjectRepository projectRepository;

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project)
    {
        return projectRepository.save(project);
    }
}
