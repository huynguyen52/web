package com.example.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "employee_tbl")
@IdClass(EmployeePK.class)
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private int employeeId;
    @Id
    private int deptId;
    private String name;
    private String email;
    private String phone;
}
