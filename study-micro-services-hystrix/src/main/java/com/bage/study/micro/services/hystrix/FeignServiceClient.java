package com.bage.study.micro.services.hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "CLOUD-CLIENT"/*,fallback = HystrixClientFallback.class*/)
public interface FeignServiceClient {

    @RequestMapping("/eurekaClient/feign")
    public String feign() ;

}
