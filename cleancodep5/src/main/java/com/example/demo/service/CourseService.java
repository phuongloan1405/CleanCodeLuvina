package com.example.demo.service;

import com.example.demo.controller.response.CourseResponse;

public interface CourseService {
    public CourseResponse sortCourse(String keyword, String orderName);
}
