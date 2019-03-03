package com.bage.study.micro.services.eureka.client6;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client6Application {


    AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/")
    public String home(@RequestParam(value = "param",required = false) String param) {
    	System.out.println(counter.incrementAndGet() + ":这是client 6 " + param);
        return "Hello 6 " + param;
    }

    public static void main(String[] args) {
    	SpringApplication.run(Client6Application.class, args);
    }

}