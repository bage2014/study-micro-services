package com.bage.study.micro.services.zuul.dynamix.routes.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RedirectionFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // String header = request.getHeader("YOUR_HEADER_PARAM");
        String serviceId = request.getParameter("serviceId");

        if ("".equals(serviceId)) {
            ctx.put("serviceId", "serviceA");
            //ctx.setRouteHost(new URL("http://Service_A_URL”));
        } else { // "YOUR_B_LOGIC"
            ctx.put("serviceId", "serviceB");
            //ctx.setRouteHost(new URL("http://Service_B_URL”));
        }
        request.getRequestURL().toString();

        return null;
    }
}
