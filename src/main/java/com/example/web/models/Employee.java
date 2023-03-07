package com.example.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @EmbeddedId
    private EmployeePK employeePKId;
    private String name;
    private String email;
    private String phone;
}
