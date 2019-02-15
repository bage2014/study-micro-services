package com.bage.study.micro.services.zuul.dynamix.routes.filter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
 
@Component
public class RouteFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
 
	@Override
	public String filterType() {
		return "route";
	}
 
	@Override
	public int filterOrder() {
		return 1;
	}
 
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		String requestURL = ctx.getRequest().getRequestURL().toString();
		return !(requestURL.contains("proxyurl") || requestURL.contains("/admin/"));
	}
 
	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
 
		log.info("RouteFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		
		return null;
	}
}
