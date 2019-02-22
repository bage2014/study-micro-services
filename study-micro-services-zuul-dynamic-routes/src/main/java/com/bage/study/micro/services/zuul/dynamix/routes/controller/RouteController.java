package com.bage.study.micro.services.zuul.dynamix.routes.controller;

import com.bage.study.micro.services.zuul.dynamix.routes.domain.Route;
import com.bage.study.micro.services.zuul.dynamix.routes.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;
    Route route = new Route("10086","/client7/*","cloud-client7");

    @RequestMapping("/insert")
    public Object insert(){
        return routeService.insert(route);
    }

    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable("id") String id){
        return routeService.delete(id);
    }

    @RequestMapping("/update")
    public Object update(){
        route.setServiceId("cloud-service7-new");
        return routeService.update(route);
    }

    @RequestMapping("/query/{id}")
    public Object query(@PathVariable("id") String id){
        return routeService.query(id);
    }

    @RequestMapping("/query/all")
    public Object queryAll(){
        return routeService.queryAll();
    }

    @RequestMapping("/refresh")
    public Object refresh(){
        return routeService.refresh();
    }

}
