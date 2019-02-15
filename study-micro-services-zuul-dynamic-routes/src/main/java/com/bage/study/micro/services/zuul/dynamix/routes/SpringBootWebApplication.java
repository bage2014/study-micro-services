package com.bage.study.micro.services.zuul.dynamix.routes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
