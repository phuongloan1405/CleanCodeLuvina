package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> create(@RequestBody User user) {
        /**
         * Trong function này thì được test thông qua Postman.
         * Tuy nhiên hiện tại mới chỉ tìm được giải pháp cho request là:
         * {
            "name": "Nguyen Van A",
            "email": "a.nguyen@gmali.com",
            "password": "123456",
            "phone": "0987654321",
            "experiences": 5,
            "mode": "TEACHER"
            }
            Cũng do sử dụng "Single Table" cho phần entity
            vì vậy mà phần factory cũng chưa áp dụng được vào chương trình này.
            
            Còn đối với request có cấu trúc như đề bài cho thì mong được cung cấp giải pháp
         */
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
