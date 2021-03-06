package com.liqiang.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ElasticSearch_9004_Application {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearch_9004_Application.class,args);
    }
}
