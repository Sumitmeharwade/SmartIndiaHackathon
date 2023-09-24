package com.sih.springproject.service;


import com.sih.springproject.model.User;
import com.sih.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addCustomer(User user)
    {
        return userRepository.save(user);
    }

    public User modifyCustomer(User user)
    {
        return userRepository.save(user);
    }

    public User deleteCustomer(User user)
    {
        User ad=userRepository.findById(user.getUserId()).get();
        userRepository.delete(user);
        return ad;
    }

    public User findCustomer(Long id)
    {
        return userRepository.findById(id).get();
    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }
}

