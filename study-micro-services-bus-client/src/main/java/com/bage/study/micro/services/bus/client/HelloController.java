package com.bage.study.micro.services.bus.client;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @RequestMapping("/{msg}")
    public String sendMsg(@PathVariable(value="msg") String msg) {
        amqpTemplate.convertAndSend("hello",msg);
        return msg;
    }

}
