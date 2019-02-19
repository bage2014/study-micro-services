package com.bage.study.micro.services.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Spencer Gibb
 */
@Component
public class AddResponseHeaderFilter extends ZuulFilter {
	public String filterType() {
		return "post";
	}

	public int filterOrder() {
		return 999;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = context.getResponse();
		servletResponse.addHeader("X-Foo",
				UUID.randomUUID().toString());
		return null;
	}
}
