package com.sih.springproject.service;


import com.sih.springproject.model.Git;

import com.sih.springproject.repository.GitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitService {
    @Autowired
    private GitRepository gitRepository;

    public Git addGit(Git git)
    {
        return gitRepository.save(git);
    }

    public Git modifyGit(Git git)
    {
        return gitRepository.save(git);
    }

    public Git deleteGit(Git git)
    {
        Git ad=gitRepository.findById(git.getGitId()).get();
        gitRepository.delete(git);
        return ad;
    }

    public Git findGit(Long id)
    {
        return gitRepository.findById(id).get();
    }

    public List<Git> findAll()
    {
        return gitRepository.findAll();
    }
}

