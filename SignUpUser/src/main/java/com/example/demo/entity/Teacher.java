package com.example.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends User {
    private String phone;
    private String experiences;

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the experiences
     */
    public String getExperiences() {
        return experiences;
    }

    /**
     * @param experiences the experiences to set
     */
    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }
}
