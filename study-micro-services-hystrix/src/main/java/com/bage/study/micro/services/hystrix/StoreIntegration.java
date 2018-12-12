package com.bage.study.micro.services.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@Component
public class StoreIntegration {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        String url = "http://CLOUD-CLIENT/eurekaClient/someUrl";
        if(parameters == null){
            url = "http://CLOUD-CLIENT/eurekaClient/feign";
        }
        ResponseEntity<String> res = restTemplate.getForEntity(url , String.class);
        return res.getBody();
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "defaultStores"; /* something useful */
    }
}
