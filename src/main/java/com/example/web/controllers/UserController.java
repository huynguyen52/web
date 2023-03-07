package com.example.web.controllers;

import com.example.web.models.User;
import com.example.web.repository.UserRepository;
import com.example.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        User res = userService.saveUser(user);
        return res;
    }

    @GetMapping
    public Iterator<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/count/{name}")
    public ResponseEntity<Integer> getCountByName(@PathVariable String name) {
        int total = userService.getCountByName(name);
        return ResponseEntity.status(200).body(total);
    }

    @GetMapping("/multi/{name}/{email}")
    public List<User> getUsersWithMultiCondition(@PathVariable String name, @PathVariable String email) {
        return userService.findByMultiCondition(name, email);
    }

    @GetMapping("/getByName")
    public List<User> getByNameIgnoreCase(@RequestParam String name) {
        return userService.findUsersIgnoreCase(name);
    }

    @GetMapping("/customQuery")
    public List<User> getUsersCustomQuery() {
        return userService.getUsersCustomQuery();
    }
}
