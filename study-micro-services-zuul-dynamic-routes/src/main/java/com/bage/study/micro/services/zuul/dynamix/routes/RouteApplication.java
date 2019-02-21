package com.bage.study.micro.services.zuul.dynamix.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class RouteApplication {

    @Autowired
    ServerProperties serverProperties;

    @Autowired
    ZuulProperties zuulProperties;

    @Bean
    public CustomRouteLocator customRouteLocator(){
        return new CustomRouteLocator(serverProperties.getServlet().getPath(),zuulProperties);
    }

    public static void main(String[] args) {
        SpringApplication.run(RouteApplication.class, args);
    }

}
