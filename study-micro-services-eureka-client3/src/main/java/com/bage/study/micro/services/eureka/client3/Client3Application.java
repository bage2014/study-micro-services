package com.bage.study.micro.services.eureka.client3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client3Application {

	@RequestMapping("/")
    public String home(HttpServletRequest request) {
    	System.out.println("这是client 3 ");
        return "Hello 3 " + request.getContextPath();
    }

    public static void main(String[] args) {
    	SpringApplication.run(Client3Application.class, args);
    }

}