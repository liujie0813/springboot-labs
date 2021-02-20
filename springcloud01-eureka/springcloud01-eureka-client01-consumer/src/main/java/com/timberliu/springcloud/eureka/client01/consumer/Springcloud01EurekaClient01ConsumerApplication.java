package com.timberliu.springcloud.eureka.client01.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud01EurekaClient01ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud01EurekaClient01ConsumerApplication.class, args);
    }

}
