package com.example.demo.service;

import java.util.List;

import com.example.demo.service.dto.CourseDto;

public interface SortStrategy {

    void sort(List<CourseDto> courses);
}
