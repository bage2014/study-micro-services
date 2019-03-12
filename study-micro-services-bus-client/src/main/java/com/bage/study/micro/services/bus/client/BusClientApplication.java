package com.bage.study.micro.services.bus.client;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@EnableDiscoveryClient
public class BusClientApplication {

  @RequestMapping("/")
  public String home() {
    return "Bus Client,Hello World";
  }


  @Bean
  public Queue helloQueue() {
    return new Queue("hello");
  }

  public static void main(String[] args) {
    SpringApplication.run(BusClientApplication.class, args);
  }

}