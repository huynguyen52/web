package com.example.web.controllers;

import com.example.web.models.User;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping()
    public User addNewUser(@RequestBody User user) {
        User res = userRepository.save(user);
        return res;
    }

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
