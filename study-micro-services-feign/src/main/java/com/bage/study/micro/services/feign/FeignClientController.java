package com.bage.study.micro.services.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("eurekaClient")
public class FeignClientController {
	
	@Autowired
	FeignServiceClient feignServiceClient;
	
	@GetMapping("/feign")
	public String feign() {
		return feignServiceClient.feign();
	}
}

