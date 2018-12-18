package com.bage.study.micro.services.eureka.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableConfigServer
public class ConfigApplication {

	@RequestMapping("/home")
    public String home(HttpServletRequest request) {
    	System.out.println("这是client register ");
        return "Hello register " + request.getContextPath();
    }

    public static void main(String[] args) {
    	SpringApplication.run(ConfigApplication.class, args);
    }

}