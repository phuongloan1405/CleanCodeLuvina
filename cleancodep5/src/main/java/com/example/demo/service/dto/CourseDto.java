package com.example.demo.service.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class CourseDto {

    private long id;
    private String name;
    private String location;
    private String teacherName;
    private Instant opened;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the opened
     */
    public Instant getOpened() {
        return opened;
    }

    /**
     * @param opened the opened to set
     */
    public void setOpened(Instant opened) {
        this.opened = opened;
    }
}
