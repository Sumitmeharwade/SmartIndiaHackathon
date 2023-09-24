package com.sih.springproject.service;


import com.sih.springproject.model.Project;
import com.sih.springproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project)
    {
        return projectRepository.save(project);
    }

    public Project modifyProject(Project project)
    {
        return projectRepository.save(project);
    }

    public Project deleteProject(Project project)
    {
        Project ad=projectRepository.findById(project.getProjectId()).get();
        projectRepository.delete(project);
        return ad;
    }

    public Project findProject(Long id)
    {
        return projectRepository.findById(id).get();
    }

    public List<Project> findAll()
    {
        return projectRepository.findAll();
    }
}

