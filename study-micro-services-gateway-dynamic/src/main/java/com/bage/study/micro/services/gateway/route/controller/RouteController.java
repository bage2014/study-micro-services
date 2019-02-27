package com.bage.study.micro.services.gateway.route.controller;

import com.bage.study.micro.services.gateway.route.domain.Predicate;
import com.bage.study.micro.services.gateway.route.domain.Route;
import com.bage.study.micro.services.gateway.route.dao.RouteMapper;
import com.bage.study.micro.services.gateway.route.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    Route route = new Route();

    @RequestMapping("/insert")
    public Object insert(){
        route.setId("cloud-client6");
        route.setUri("lb://cloud-client6");
        Predicate predicate = new Predicate();
        predicate.setName("Path");
        Map<String, String> args = new HashMap<>();
        args.put("pattern", "/client6/**");
        predicate.setArgs(args);
        route.setPredicates(Arrays.asList(predicate));
        return routeService.insert(route);
    }

    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable("id") String id){
        route.setId("cloud-client6");
        route.setUri("lb://cloud-client66");
        Predicate predicate = new Predicate();
        predicate.setName("Path");
        Map<String, String> args = new HashMap<>();
        args.put("pattern", "/client6/**");
        predicate.setArgs(args);
        route.setPredicates(Arrays.asList(predicate));
        return routeService.delete(id);
    }

    @RequestMapping("/update")
    public Object update(){
        route.setId("cloud-client6");
        route.setUri("lb://cloud-client7");
        Predicate predicate = new Predicate();
        predicate.setName("Path");
        Map<String, String> args = new HashMap<>();
        args.put("pattern", "/client6/**");
        predicate.setArgs(args);
        route.setPredicates(Arrays.asList(predicate));
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
        routeService.refresh();
        return 1;
    }

}
