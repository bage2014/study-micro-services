package com.bage.study.micro.services.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class GatewayApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello Spring Gateway";
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new CustomerGatewayFilter())
                                .addResponseHeader("X-Response-test", "test"))
                        .uri("http://httpbin.org:80/get")
                        .id("customer_filter_router")
                )
                .route(r -> r.path("/throttle/**")
                        .filters(f -> f.filter(new ThrottleGatewayFilter())
                                .addResponseHeader("X-throttle-test", "throttle"))
                        .uri("http://httpbin.org:80/throttle")
                        .id("throttle")
                )
                .build();
    }
}
