package com.timberliu.springcloud.eureka.client01.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud01EurekaClient01ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud01EurekaClient01ProviderApplication.class, args);
    }

}
