package com.example.demo.service.strategy;

import java.util.Comparator;
import java.util.List;

import com.example.demo.service.SortStrategy;
import com.example.demo.service.dto.CourseDto;

public class SortByName implements SortStrategy {
    @Override
    public void sort(List<CourseDto> courses) {
        courses.sort(Comparator.comparing(CourseDto::getName));
    }
}
