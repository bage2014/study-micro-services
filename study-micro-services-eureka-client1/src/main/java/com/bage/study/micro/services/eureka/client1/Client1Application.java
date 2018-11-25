package com.bage.study.micro.services.eureka.client1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client1Application {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
    	System.out.println("这是client 1 ");
        return "Hello 1 " + request.getContextPath();
    }

    public static void main(String[] args) {
    	SpringApplication.run(Client1Application.class, args);
    }

}