package com.bage.study.micro.services.eureka.client2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eurekaClient")
public class EurekaClientController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/services")
	public List<ServiceInstance> client(@RequestParam("serviceId") String serviceId) {
		return discoveryClient.getInstances(serviceId);
	}

	@GetMapping("/clients")
	public String client() {
		List<String> list = discoveryClient.getServices();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(list.get(i) + ",");
		}
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

	@GetMapping("/feign")
	public String feign() {
		System.out.println("22222");
		return "2";
	}
}

