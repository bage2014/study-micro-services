package com.bage.study.micro.services.zuul.filters;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * @author Spencer Gibb
 */
@Component
public class ModifyResponseBodyFilter extends ZuulFilter {
	public String filterType() {
		return "post";
	}

	public int filterOrder() {
		return 999;
	}

	public boolean shouldFilter() {
		RequestContext context = getCurrentContext();
		return context.getRequest().getParameter("service") == null;
	}

	public Object run() {
		try {
			RequestContext context = getCurrentContext();
			InputStream stream = context.getResponseDataStream();
			String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
			context.setResponseBody("Modified via setResponseBody(): "+body);
		}
		catch (IOException e) {
			rethrowRuntimeException(e);
		}
		return null;
	}
}