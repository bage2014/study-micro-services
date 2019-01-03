package com.bage.study.micro.services.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eurekaClient")
public class FeignClientController {

	private static Logger log = LoggerFactory.getLogger(FeignClientController.class);


	@Autowired
	FeignServiceClient feignServiceClient;
	
	@GetMapping("/feign")
	public String feign() {
		log.info("----------feign----------");
		return feignServiceClient.feign();
	}
}

