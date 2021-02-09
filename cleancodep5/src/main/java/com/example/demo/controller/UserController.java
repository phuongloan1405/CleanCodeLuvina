package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{name}")
    public List<User> getUser(@PathVariable("name") final String name) {
        return userRepository.findByName(name);

    }

    @GetMapping("/user/id/{user_id}")
    public User getId(@PathVariable(value = "user_id") long userId) {
        return userRepository.findById(userId).get();
    }

    @GetMapping("/user/update/{id}/{name}")
    public User update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {

        User User = getId(id);
        User.setName(name);

        return userRepository.save(User);
    }
}
