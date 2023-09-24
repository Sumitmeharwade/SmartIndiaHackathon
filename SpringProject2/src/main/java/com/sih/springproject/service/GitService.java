package com.sih.springproject.service;


import com.sih.springproject.model.Git;
import com.sih.springproject.model.Rating;
import com.sih.springproject.repository.GitRepository;
import com.sih.springproject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitService {
    @Autowired
    private GitRepository gitRepository;

    public Git addCustomer(Git git)
    {
        return gitRepository.save(git);
    }

    public Git modifyCustomer(Git git)
    {
        return gitRepository.save(git);
    }

    public Git deleteCustomer(Git git)
    {
        Git ad=gitRepository.findById(git.getGitId()).get();
        gitRepository.delete(git);
        return ad;
    }

    public Git findCustomer(Long id)
    {
        return gitRepository.findById(id).get();
    }

    public List<Git> findAll()
    {
        return gitRepository.findAll();
    }
}

