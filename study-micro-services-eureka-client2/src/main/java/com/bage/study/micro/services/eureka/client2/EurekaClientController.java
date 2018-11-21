package com.bage.study.micro.services.eureka.client2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;

@RestController
@RequestMapping("eurekaClient")
public class EurekaClientController {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	@RequestMapping("serviceUrl")
	public String serviceUrl() {
	    Applications apps = discoveryClient.getApplications();
	    return apps.getAppsHashCode();
	}
}

