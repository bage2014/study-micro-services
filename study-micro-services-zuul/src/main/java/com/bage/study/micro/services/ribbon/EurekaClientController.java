package com.bage.study.micro.services.ribbon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("eurekaClient")
public class EurekaClientController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/clients/{clientName}")
	public String doSomeThing(@PathVariable("clientName") String clientName) {
		
		List<String> list = discoveryClient.getServices();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(list.get(i) + ",");
		}
		System.out.println(stringBuilder.toString());

		return stringBuilder.toString();
	}
	
	
}

