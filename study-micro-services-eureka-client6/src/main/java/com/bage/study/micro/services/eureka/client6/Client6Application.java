package com.bage.study.micro.services.eureka.client6;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client6Application {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
    	System.out.println("这是client 6 ");
        return "Hello 6 " + request.getContextPath();
    }

    public static void main(String[] args) {
    	SpringApplication.run(Client6Application.class, args);
    }

}