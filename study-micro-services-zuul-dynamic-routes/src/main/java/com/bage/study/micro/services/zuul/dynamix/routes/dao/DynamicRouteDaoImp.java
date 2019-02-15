package com.bage.study.micro.services.zuul.dynamix.routes.dao;

import java.util.HashMap;
import java.util.Map;

import com.bage.study.micro.services.zuul.dynamix.routes.model.DynamicRoute;
import org.springframework.stereotype.Repository;

@Repository
public class DynamicRouteDaoImp implements DynamicRouteDao {

	Map<String, DynamicRoute> map = new HashMap<String, DynamicRoute>();
	
	@Override
	public Map<String, DynamicRoute> findAll() {
		return map;
	}

	@Override
	public void delete(DynamicRoute dynamicRoute) {
		map.remove(dynamicRoute.getRequestURIUniqueKey());	
	}

	@Override
	public DynamicRoute save(DynamicRoute dynamicRoute) {
		return map.put(dynamicRoute.getRequestURIUniqueKey(), dynamicRoute);
	}

}
