package com.bage.study.micro.services.eureka.client2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableDiscoveryClient // 在 spring-cloud-dependencies的Finchley.SR2 版本中可以不用添加此注解
@RestController
public class Client2Application {

	@RequestMapping("/home")
    public String home(HttpServletRequest request) {
    	System.out.println("这是client 2 ");
        return "Hello 2 " + request.getContextPath();
    }

    public static void main(String[] args) {
    	SpringApplication.run(Client2Application.class, args);
    }

}