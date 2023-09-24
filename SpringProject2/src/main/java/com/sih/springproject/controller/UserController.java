package com.sih.springproject.controller;


import com.sih.springproject.model.User;
import com.sih.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sih.springproject.commons.Constants.crossOrigins;


@CrossOrigin(origins = crossOrigins)
@RestController
@RequestMapping("/User")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable Long userId)
    {
        return userService.findUser(userId);
    }
    @GetMapping("/getall")
    public List<User> getAllUser(){
        return userService.findAll();
    }
}
