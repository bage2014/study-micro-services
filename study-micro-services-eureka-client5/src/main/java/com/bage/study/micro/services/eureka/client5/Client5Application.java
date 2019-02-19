package com.bage.study.micro.services.eureka.client5;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client5Application {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
    	System.out.println("这是client 5 ");
        return "Hello 5 " + request.getContextPath();
    }

    public static void main(String[] args) {
    	SpringApplication.run(Client5Application.class, args);
    }

}