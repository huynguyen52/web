package com.example.web.services;

import com.example.web.dto.InputRequest;
import com.example.web.models.Employee;
import com.example.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(InputRequest<Employee> request) {
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Employee employee = request.getEmployee();
        employee.setCreatedBy(currentUser);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, double salary, InputRequest<Employee> request) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee!= null){
            employee.setSalary(salary);
            employee.setLastModifiedBy(request.getLoggedInUser());
            return employeeRepository.saveAndFlush(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }
}
