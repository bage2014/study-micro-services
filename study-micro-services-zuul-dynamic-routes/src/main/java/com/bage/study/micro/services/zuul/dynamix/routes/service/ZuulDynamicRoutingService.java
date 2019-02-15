package com.bage.study.micro.services.zuul.dynamix.routes.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.bage.study.micro.services.zuul.dynamix.routes.model.DynamicRoute;
import com.bage.study.micro.services.zuul.dynamix.routes.model.DynamicRouteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bage.study.micro.services.zuul.dynamix.routes.dao.DynamicRouteDao;


@Service
public class ZuulDynamicRoutingService {

	private static final Logger logger = LoggerFactory.getLogger(ZuulDynamicRoutingService.class);
	private static final String HTTP_PROTOCOL = "http://";

	private final ZuulProperties zuulProperties;
	private final ZuulHandlerMapping zuulHandlerMapping;

	private final DynamicRouteDao dynamicRouteRedisRepository;
	
	@Autowired
	public ZuulDynamicRoutingService(final ZuulProperties zuulProperties, final ZuulHandlerMapping zuulHandlerMapping,
			final DynamicRouteDao dynamicRouteRedisRepository) {
		this.zuulProperties = zuulProperties;
		this.zuulHandlerMapping = zuulHandlerMapping;
		this.dynamicRouteRedisRepository = dynamicRouteRedisRepository;
	}
	
	/**
	 * Load all routes from redis cache to restore the existing routes while restarting the zuul server
	 */
	@PostConstruct
	public void initialize() {
		try {
			Map<String, DynamicRoute> map = dynamicRouteRedisRepository.findAll();
			Set<Entry<String, DynamicRoute>> set = map.entrySet();
			for (Entry<String, DynamicRoute> rout : set) {
				addDynamicRouteInZuul(rout.getValue());
			}
			zuulHandlerMapping.setDirty(true);
		} catch (Exception e) {
			logger.error("Exception in loading any previous route while restarting zuul routes.", e);
	    }
	}

	public Map<String, DynamicRoute> findAll() {
		return dynamicRouteRedisRepository.findAll();
	}
	public DynamicRouteResponse addDynamicRoute(DynamicRoute dynamicRoute) {
		logger.debug("request received in service to add {}", dynamicRoute);
		addDynamicRouteInZuul(dynamicRoute);
		
		logger.debug("going to add in cache {}", dynamicRoute);
		addToCache(dynamicRoute);
		logger.debug("added in cache {}", dynamicRoute);
		zuulHandlerMapping.setDirty(true);

		DynamicRouteResponse dynamicRouteResponse = new DynamicRouteResponse();
		logger.debug("response sent {}", dynamicRouteResponse);
		return dynamicRouteResponse;
	}

	public Boolean removeDynamicRoute(final String requestURIUniqueKey) {
		DynamicRoute dynamicRoute = new DynamicRoute();
		//Removal from redis will be done from unique key. No need for other params. So create object
		//with just unique key
		dynamicRoute.setRequestURIUniqueKey(requestURIUniqueKey);
		if (zuulProperties.getRoutes().containsKey(requestURIUniqueKey)) {
			ZuulRoute zuulRoute = zuulProperties.getRoutes().remove(requestURIUniqueKey);
			logger.debug("removed the zuul route {}", zuulRoute);
			//Removal from redis will be done from unique key. No need for other params
			removeFromCache(dynamicRoute);
			zuulHandlerMapping.setDirty(true);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private void addDynamicRouteInZuul(DynamicRoute dynamicRoute) {
		String url = createTargetURL(dynamicRoute);
		zuulProperties.getRoutes().put(dynamicRoute.getRequestURIUniqueKey(),
				new ZuulRoute(dynamicRoute.getRequestURIUniqueKey(), dynamicRoute.getRequestURI() + "/**",
						null, url, true, false, new HashSet<>()));
	}

	private String createTargetURL(DynamicRoute dynamicRoute) {
		StringBuilder sb = new StringBuilder(HTTP_PROTOCOL);
		sb.append(dynamicRoute.getTargetURLHost()).append(":").append(dynamicRoute.getTargetURLPort());
		if (StringUtils.isEmpty(dynamicRoute.getTargetURIPath())) {
			sb.append("");
		} else {
			sb.append(dynamicRoute.getTargetURIPath());
		}
		String url = sb.toString();
		return url;
	}
	private void addToCache(final DynamicRoute dynamicRoute) {
		DynamicRoute dynamicRouteSaved = dynamicRouteRedisRepository.save(dynamicRoute);
		logger.debug("Added in cache {}", dynamicRouteSaved);
	}
	
	private void removeFromCache(final DynamicRoute dynamicRoute) {
		logger.debug("removing the dynamic route {}", dynamicRoute);
		//Removal from redis will be done from unique key. No need for other params
		dynamicRouteRedisRepository.delete(dynamicRoute);
	}

}
