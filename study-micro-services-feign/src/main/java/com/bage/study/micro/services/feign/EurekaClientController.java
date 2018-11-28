package com.bage.study.micro.services.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("CLOUD-CLIENT")
@FeignClient("CLOUD-CLIENT")
public class EurekaClientController {

	@GetMapping("/home")
	public String home() {
	    return "";
		// return res.getBody();
	}
	
	
}

