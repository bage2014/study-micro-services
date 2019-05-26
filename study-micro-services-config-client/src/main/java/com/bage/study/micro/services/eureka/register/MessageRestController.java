package com.bage.study.micro.services.eureka.register;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

    @Value("${config:Hello default}")
    private String config;
    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/config")
    String getConfig() {
        return this.config;
    }
    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}