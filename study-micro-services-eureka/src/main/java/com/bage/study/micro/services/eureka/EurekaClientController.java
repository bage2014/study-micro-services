package com.bage.study.micro.services.eureka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

@RestController
@RequestMapping("eurekaClient")
public class EurekaClientController {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	@RequestMapping("serviceUrl")
	public String serviceUrl() {
		Applications apps = discoveryClient.getApplications();
		List<Application> list = apps.getRegisteredApplications();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(list.get(i).getName() + ",");
		}
		return stringBuilder.toString();
	}
}

