package com.bage.study.micro.services.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("CLOUD-CLIENT")
public interface FeignServiceClient {

    @RequestMapping("/eurekaClient/feign")
    public String feign() ;

}
