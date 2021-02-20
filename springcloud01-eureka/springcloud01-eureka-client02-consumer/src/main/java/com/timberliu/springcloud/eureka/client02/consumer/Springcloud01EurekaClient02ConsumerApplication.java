package com.timberliu.springcloud.eureka.client02.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud01EurekaClient02ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud01EurekaClient02ConsumerApplication.class, args);
    }

}
