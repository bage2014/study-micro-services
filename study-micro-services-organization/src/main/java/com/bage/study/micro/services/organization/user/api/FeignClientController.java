package com.bage.study.micro.services.organization.user.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/eurekaClient")
public class FeignClientController {
	
	@Autowired
	FeignServiceClient feignServiceClient;
	
	@GetMapping("/feign")
	@HystrixCommand(fallbackMethod = "defaultFallbackMethod")
	public String feign() {
		return feignServiceClient.feign();
	}

	public String defaultFallbackMethod() {
		return "defaultStores"; /* something useful */
	}


}

