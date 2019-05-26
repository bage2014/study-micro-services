package com.bage.study.micro.services.eureka.register;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

    @Value("${name:Hello default}")
    private String name;
    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/name")
    String getConfig() {
        return this.name;
    }
    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}