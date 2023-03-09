package com.example.web.controllers;

import com.example.web.entities.Course;
import com.example.web.entities.Student;
import com.example.web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @PostMapping("/register-course")
    public Student registerCourse() {
        Course courseA = new Course("Course A");
        Course courseB = new Course("Course B");
        List<Course> courses = new ArrayList<>();
        courses.add(courseA);
        courses.add(courseB);

        Student student = new Student("John");
        student.setCourses(courses);

        return studentService.save(student);
    }
}
