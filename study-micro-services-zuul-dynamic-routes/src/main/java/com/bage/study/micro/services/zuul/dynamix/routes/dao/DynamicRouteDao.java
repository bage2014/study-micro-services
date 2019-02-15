package com.bage.study.micro.services.zuul.dynamix.routes.dao;

import java.util.Map;

import com.bage.study.micro.services.zuul.dynamix.routes.model.DynamicRoute;

public interface DynamicRouteDao  {

	Map<String, DynamicRoute> findAll();

	void delete(DynamicRoute dynamicRoute);

	DynamicRoute save(DynamicRoute dynamicRoute);
	
	
}