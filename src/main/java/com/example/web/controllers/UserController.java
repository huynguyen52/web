package com.example.web.controllers;

import com.example.web.entities.Address;
import com.example.web.entities.User;
import com.example.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/register-user")
    public User registerUser() {
        User user = new User("example@mail.com", "012378342");
        Address address = new Address("asd", "asd");
        user.setAddress(address);

        return userService.save(user);
    }

}
