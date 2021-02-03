package com.example.demo.factory;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;

public class UserFactory {
    private UserFactory() {
    }

    public static final User getUser(String mode) {
        switch (mode) {

        case "TEACHER":
            return new Teacher();

        case "STUDENT":
            return new Student();

        default:
            throw new IllegalArgumentException("This user type is unsupported");
        }
    }
}
