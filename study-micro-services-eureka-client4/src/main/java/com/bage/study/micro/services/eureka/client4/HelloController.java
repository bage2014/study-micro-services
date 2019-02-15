package com.bage.study.micro.services.eureka.client4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Not Spring Boot Client";
    }

    @RequestMapping("/ribbon")
    @ResponseBody
    public String ribbon(){
        System.out.println("hello ribbon");
        return RibbonRestClient.executeWithLoadBalancer("cloud-ribbon" , "");
    }

}
