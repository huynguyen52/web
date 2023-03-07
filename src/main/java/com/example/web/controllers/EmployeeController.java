package com.example.web.controllers;

import com.example.web.dto.InputRequest;
import com.example.web.models.Employee;
import com.example.web.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody InputRequest<Employee> request) {
        return employeeService.saveEmployee(request);
    }

    @PutMapping("/{id}/{salary}")
    public Employee updateEmployee(@PathVariable int id, @PathVariable double salary, @RequestBody InputRequest<Employee> request) {
        return employeeService.updateEmployee(id, salary, request);
    }
}
