package com.example.web.controllers;

import com.example.web.models.Employee;
import com.example.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
