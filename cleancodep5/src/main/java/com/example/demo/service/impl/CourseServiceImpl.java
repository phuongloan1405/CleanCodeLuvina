package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.response.CourseResponse;
import com.example.demo.entity.Course;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.respository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.SortStrategy;
import com.example.demo.service.dto.CourseDto;
import com.example.demo.service.strategy.SortByName;
import com.example.demo.service.strategy.SortByOpened;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    private static Map<String, SortStrategy> strategies;

    static {
        strategies = new HashMap<>();
        strategies.put("name", new SortByName());
        strategies.put("opened", new SortByOpened());
    }
    
    @Override
    public CourseResponse sortCourse(String keyword, String orderName) {
        CourseResponse response = new CourseResponse();
        List<Course> courses = new ArrayList<>();
        List<CourseDto> data = new ArrayList<>();
        if (keyword == null || keyword.isEmpty()) {
            courses = courseRepository.findAll();
        } else {
            courses = courseRepository.findAllByCourseNameLike(keyword);
        }
        for (Course course : courses) {
            CourseDto dto = new CourseDto();
            dto.setName(course.getCourseName());
            dto.setId(course.getTeacher().getId());
            dto.setLocation(course.getLocation());
            dto.setTeacherName(course.getTeacher().getUser().getName());
            dto.setOpened(course.getOpened());
            data.add(dto);
        }
        if (orderName != null) {
            SortStrategy sortingStrategy = lookupSortingStrategy(orderName);
            sortingStrategy.sort(data);
        }
        response.setInforCourse(data);
        return response;
    }

    private SortStrategy lookupSortingStrategy(String strategyName) {
        SortStrategy sortingStrategy = strategies.get(strategyName);
        if (sortingStrategy == null) {
            throw new ResourceNotFoundException("Unsupported sorting strategy");
        }
        return sortingStrategy;
    }
}
