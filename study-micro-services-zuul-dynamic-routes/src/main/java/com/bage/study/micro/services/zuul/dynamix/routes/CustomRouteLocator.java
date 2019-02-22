package com.bage.study.micro.services.zuul.dynamix.routes;

import com.bage.study.micro.services.zuul.dynamix.routes.service.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private ZuulProperties zuulProperties;

    @Autowired
    private RouteServiceImpl routeService;

    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.zuulProperties = properties;
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        Map<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap();

        zuulProperties.getRoutes().clear(); // 先清空

        routesMap.putAll(super.locateRoutes());

        routesMap.putAll(locateRoutesFromDb());

        zuulProperties.getRoutes().putAll(routesMap); //  放入配置的路由

        return routesMap;
    }

    private Map<? extends String, ? extends ZuulProperties.ZuulRoute> locateRoutesFromDb() {
        List<com.bage.study.micro.services.zuul.dynamix.routes.domain.Route> list = routeService.queryAllFromCache();
             Map<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap();
        for (int i = 0; i < list.size(); i++) {
            com.bage.study.micro.services.zuul.dynamix.routes.domain.Route item = list.get(i);
            routesMap.put(item.getPathPattern(),new ZuulProperties.ZuulRoute(
                    item.getId(),
                    item.getPathPattern(),
                    item.getServiceId(),
                    item.getUrl(),
                    item.isStripPrefix(),
                    item.getRetryable(),
                    item.getSensitiveHeaders()
                    ));
        }
        return routesMap;
    }

    @Override
    public Collection<String> getIgnoredPaths() {
        return super.getIgnoredPaths();
    }

    @Override
    public List<Route> getRoutes() {
        return super.getRoutes();
    }

    @Override
    public Route getMatchingRoute(String path) {
        return super.getMatchingRoute(path);
    }
}
