package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/findall")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(HttpServletResponse response) {
        return repository.findAll();
    }

    @GetMapping("/finduser/{id}")
    public User findUser(@PathVariable(value = "id") long userId) {
        return this.repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> create(@RequestBody User user) {
        if (!ObjectUtils.isEmpty(repository.findByEmail(user.getEmail()))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        User res = repository.save(user);
        if (!ObjectUtils.isEmpty(res)) {
            res.setPassword("******");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
