package com.haishangxian.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableHystrix
public class TestServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestServerApplication.class,args);
    }
}
