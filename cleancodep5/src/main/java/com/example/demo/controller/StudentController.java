package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.respository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/student/all")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    
    @GetMapping(value = "/student/update/{name}")
    public List<Student> update(@PathVariable final String name) {
        
        Student student = new Student();
        User user = new User();
        user.setName(name);
        user.setEmail(name + "@gmail.com");
        user.setPassword("123456");
        
        student.setYear("2000");
        student.setUser(user);
        
        return studentRepository.findAll();
    }
}
