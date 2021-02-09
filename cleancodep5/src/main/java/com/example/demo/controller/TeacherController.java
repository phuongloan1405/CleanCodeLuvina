package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.respository.TeacherRepository;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping(value = "/teacher/all")
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }
    
    @GetMapping(value = "/teacher/update/{name}")
    public List<Teacher> update(@PathVariable final String name) {
        
        Teacher teacher = new Teacher();
        User user = new User();
        user.setName(name);
        user.setEmail(name + "@gmail.com");
        user.setPassword("123456");
        
        teacher.setPhone("0966888222");
        teacher.setExperiences("3");
        teacher.setUser(user);
        
        teacherRepository.save(teacher);
        
        return teacherRepository.findAll();
    }
}
