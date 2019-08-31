package com.liqiang.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_4399_Application {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_4399_Application.class,args);
    }
}
