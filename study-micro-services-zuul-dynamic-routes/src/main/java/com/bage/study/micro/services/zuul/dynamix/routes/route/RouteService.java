package com.bage.study.micro.services.zuul.dynamix.routes.route;

import com.bage.study.micro.services.zuul.dynamix.routes.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    List<Route> list = new ArrayList<Route>();
    int id = 1;

    @Autowired
    private ZuulProperties zuulProperties;

    public void init(){

        // String id, String path, String serviceId, String url,
        //boolean stripPrefix, Boolean retryable, Set<String> sensitiveHeaders
        list.add(new Route(
                String.valueOf(id ++),
                "/client5/**",
               "cloud-client5",
                null,
                true,
                true,
                true
        ));

    }

    public void add(){
        Route item = new Route(
                String.valueOf(id ++),
                "/client6/**",
                "cloud-client6",
                null,
                true,
                true,
                true
        );
        list.add(item);

        zuulProperties.getRoutes().put(item.getId(),new ZuulProperties.ZuulRoute(
                item.getId(),
                item.getPath(),
                item.getServiceId(),
                item.getUrl(),
                item.isStripPrefix(),
                item.isRetryable(),
                null
        ));
    }
    public List<Route> queryAll(){
        return list;
    }
}
