package com.sih.springproject.service;


import com.sih.springproject.model.Project;
import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.ProjectRepository;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project addCustomer(Project project)
    {
        return projectRepository.save(project);
    }

    public Project modifyCustomer(Project project)
    {
        return projectRepository.save(project);
    }

    public Project deleteCustomer(Project project)
    {
        Project ad=projectRepository.findById(project.getProjectId()).get();
        projectRepository.delete(project);
        return ad;
    }

    public Project findCustomer(Long id)
    {
        return projectRepository.findById(id).get();
    }

    public List<Project> findAll()
    {
        return projectRepository.findAll();
    }
}

