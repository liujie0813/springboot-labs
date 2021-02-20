package com.timberliu.springcloud.eureka.client01.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by liujie on 2021/2/20
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(String name) {
        ServiceInstance serviceInstance;
        if (true) {
            List<ServiceInstance> instances = discoveryClient.getInstances("client01-provider");
            serviceInstance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            serviceInstance = loadBalancerClient.choose("client01-provider");
        }

        String targetUrl = serviceInstance.getUri() + "/hello?name=" + name;
        String response = restTemplate.getForEntity(targetUrl, String.class).getBody();
        return "consumer: " + response;
    }

}
