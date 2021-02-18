package com.timberliu.springboot.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class Springboot09ValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09ValidationApplication.class, args);
    }

}
