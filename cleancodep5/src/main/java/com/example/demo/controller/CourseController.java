package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.response.CourseResponse;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE) ResponseEntity<CourseResponse> sortCourse(
            @RequestParam(required = false, name = "keyword") String keyword,
            @RequestParam(required = false, name = "sortName") String sortName) {
        return ResponseEntity.ok(courseService.sortCourse(keyword, sortName));
    }
}
