package com.timberliu.springcloud.eureka.client02.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liujie on 2021/2/20
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello: " + name;
    }
}
