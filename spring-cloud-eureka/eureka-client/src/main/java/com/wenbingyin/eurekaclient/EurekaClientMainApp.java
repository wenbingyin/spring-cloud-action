package com.wenbingyin.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientMainApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientMainApp.class, args);
    }
}
