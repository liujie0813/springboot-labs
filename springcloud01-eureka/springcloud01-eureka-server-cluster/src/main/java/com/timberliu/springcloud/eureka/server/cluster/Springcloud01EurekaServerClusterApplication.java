package com.timberliu.springcloud.eureka.server.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class Springcloud01EurekaServerClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud01EurekaServerClusterApplication.class, args);
    }

}
