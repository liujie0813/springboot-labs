package com.timberliu.springboot.springmvc.message.converter.controller;

import com.timberliu.springboot.springmvc.message.converter.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by Timber in 2020/7/6
 */
@RestController
public class TestController1 {

    @PostMapping("/users")
    public User test(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

}
