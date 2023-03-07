package com.example.web.repository;

import com.example.web.models.Employee;
import com.example.web.models.EmployeePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeePK> {
}
