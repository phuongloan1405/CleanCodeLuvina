package com.example.demo.controller.response;

import java.util.List;

import com.example.demo.service.dto.CourseDto;

import lombok.Data;

@Data
public class CourseResponse {
    private List<CourseDto> inforCourse;

    /**
     * @return the inforCourse
     */
    public List<CourseDto> getInforCourse() {
        return inforCourse;
    }

    /**
     * @param inforCourse the inforCourse to set
     */
    public void setInforCourse(List<CourseDto> inforCourse) {
        this.inforCourse = inforCourse;
    }
}
