package com.bage.study.micro.services.zuul.dynamix.routes.controller;

import com.bage.study.micro.services.zuul.dynamix.routes.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicRouteController {

    @Autowired
    RouteService service;


    @RequestMapping("/add")
    public String add(){
        service.add();
        return "";
    }

}
