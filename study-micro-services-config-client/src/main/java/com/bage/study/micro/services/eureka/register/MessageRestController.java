package com.bage.study.micro.services.eureka.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

    @Value("${Header.title:Hello default}")
    private String name;
    @Value("${message:Hello default}")
    private String message;

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ContextRefresher refresher;

    @RequestMapping("/environment")
    String environment() {
        return environment.toString();
    }

    @RequestMapping("/refresher")
    String refresher() {
        return String.valueOf(refresher.refresh());
    }

    @RequestMapping("/name")
    String getConfig() {
        return this.name;
    }
    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}