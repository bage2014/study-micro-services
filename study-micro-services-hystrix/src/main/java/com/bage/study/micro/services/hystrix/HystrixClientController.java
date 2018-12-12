package com.bage.study.micro.services.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/hystrixClient")
public class HystrixClientController {

	@Autowired
	StoreIntegration storeIntegration;
	
	@GetMapping("/rest/success")
	public String succes() {
		return String.valueOf(storeIntegration.getStores(null));
	}
	@GetMapping("/rest/error")
	public String error() {
		return String.valueOf(storeIntegration.getStores(new HashMap<>()));
	}
}

