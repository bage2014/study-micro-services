package com.bage.study.micro.services.organization.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("CLOUD-CLIENT")
public interface FeignServiceClient {

    @RequestMapping("/eurekaClient/feign")
    public String feign() ;

}
