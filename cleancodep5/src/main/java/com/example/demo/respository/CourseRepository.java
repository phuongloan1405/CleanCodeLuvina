package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByCourseNameLike(String keyword);
}