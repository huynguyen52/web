package com.example.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AuthController {
    @GetMapping("/login")
    public String index() {
        return "login/index";
    }

    @GetMapping("/register")
    public String register() {
        return "register/index";
    }
}
