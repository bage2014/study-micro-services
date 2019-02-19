package com.bage.study.micro.services.zuul.dynamix.routes.controller;

import com.bage.study.micro.services.zuul.dynamix.routes.model.DeleteRouteRequest;
import com.bage.study.micro.services.zuul.dynamix.routes.model.DynamicRoute;
import com.bage.study.micro.services.zuul.dynamix.routes.model.DynamicRouteResponse;
import com.bage.study.micro.services.zuul.dynamix.routes.service.ZuulDynamicRoutingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DynamicRouteController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DynamicRouteController.class);
	
	@Autowired
    ZuulDynamicRoutingService zuulDynamicRoutingService;

	@RequestMapping(value = "/proxyurl", method = RequestMethod.POST)
	public @ResponseBody
    DynamicRouteResponse getProxyURL(@RequestBody DynamicRoute dynamicRoute) {
		logger.debug("request received to add {}", dynamicRoute);
		DynamicRouteResponse dynamicRouteResponse = zuulDynamicRoutingService.addDynamicRoute(dynamicRoute);
		logger.debug("response sent {}", dynamicRouteResponse);
		return dynamicRouteResponse;
	}
	
	@RequestMapping(value = "/proxyurl", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteProxyURL(@RequestBody DeleteRouteRequest deleteRouteRequest) {
		logger.debug("request received to delete {}", deleteRouteRequest);
		Boolean response = zuulDynamicRoutingService.removeDynamicRoute(deleteRouteRequest.getRequestURIUniqueKey());
		logger.debug("response sent for delete {}", response);
		return response;
	}
	
	@RequestMapping(value = "/proxyurl", method = RequestMethod.GET)
	public @ResponseBody DynamicRouteResponse getProxyURL() {
		DynamicRoute dynamicRoute = new DynamicRoute();
		
		dynamicRoute.setRequestURI("/gateway/**");
		dynamicRoute.setRequestURIUniqueKey("requestURIUniqueKey-liems-gateway");
		dynamicRoute.setTargetURIPath("/");
		dynamicRoute.setTargetURLHost("localhost");
		dynamicRoute.setTargetURLPort(8888);
		
		logger.debug("request received to add {}", dynamicRoute);
		DynamicRouteResponse dynamicRouteResponse = zuulDynamicRoutingService.addDynamicRoute(dynamicRoute);
		logger.debug("response sent {}", dynamicRouteResponse);
		
		return dynamicRouteResponse;
	}
	
	@RequestMapping(value = "/admin/add")
	public @ResponseBody DynamicRouteResponse getProxyURL(@RequestParam("serviceId") String serviceId) {
		DynamicRoute dynamicRoute = new DynamicRoute();
		
		dynamicRoute.setRequestURI("/clients/**");
		dynamicRoute.setRequestURIUniqueKey("requestURIUniqueKey" + serviceId);
		dynamicRoute.setTargetURIPath("/" + serviceId);
		dynamicRoute.setTargetURLHost("localhost");
		dynamicRoute.setTargetURLPort(8888);
		
		logger.debug("request received to add {}", dynamicRoute);
		DynamicRouteResponse dynamicRouteResponse = zuulDynamicRoutingService.addDynamicRoute(dynamicRoute);
		logger.debug("response sent {}", dynamicRouteResponse);
		return dynamicRouteResponse;
	}
	
	@RequestMapping(value = "/admin/delete")
	public @ResponseBody Boolean deleteProxyURL(@RequestParam("serviceId") String serviceId) {
		DynamicRoute deleteRouteRequest = new DynamicRoute();
		
		deleteRouteRequest.setRequestURIUniqueKey("requestURIUniqueKey" + serviceId);
		
		logger.debug("request received to delete {}", deleteRouteRequest);
		Boolean response = zuulDynamicRoutingService.removeDynamicRoute(deleteRouteRequest.getRequestURIUniqueKey());
		logger.debug("response sent for delete {}", response);
		return response;
	}

	@RequestMapping(value = "/admin/routes")
	public @ResponseBody
	Map<String, DynamicRoute> routes() {
		return  zuulDynamicRoutingService.findAll();
	}
}
