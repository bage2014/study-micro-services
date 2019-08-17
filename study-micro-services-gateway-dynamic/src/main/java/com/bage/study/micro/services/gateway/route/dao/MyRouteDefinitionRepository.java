package com.bage.study.micro.services.gateway.route.dao;

import com.bage.study.micro.services.gateway.route.RouteBuilder;
import com.bage.study.micro.services.gateway.route.dao.RouteMapper;
import com.bage.study.micro.services.gateway.route.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class MyRouteDefinitionRepository implements RouteDefinitionRepository,RouteMapper {

    @Autowired
    RouteMapper routeMapper;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        try {
            List<Route> routes = queryAll();
            System.out.println("routes:::" + routes.size());
            List<RouteDefinition> routeDefinitions = RouteBuilder.toRouteDefinition(routes);
            System.out.println(routeDefinitions);
            return Flux.fromIterable(routeDefinitions);
        } catch (Exception e) {
            e.printStackTrace();
            return Flux.empty();
        }
    }
    @Override
    public Mono<Void> save(Mono<RouteDefinition> routeDefinition) {
        return routeDefinition.flatMap(r -> {
            try {
                System.out.println("routeDefinition:::" + routeDefinition);
                insert(RouteBuilder.fromRouteDefinition(r));
                return Mono.empty();
            } catch (Exception e) {
                e.printStackTrace();
                return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition save error: "+ r.getId())));
            }

        });

    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            try {
                System.out.println("routeId:::" + routeId);
                delete(id);
                return Mono.empty();
            } catch (Exception e) {
                e.printStackTrace();
                return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition delete error: " + routeId)));
            }
        });

    }

    @Override
    public int insert(Route route) {
        return routeMapper.insert(route);
    }

    @Override
    public int delete(String id) {
        return routeMapper.delete(id);
    }

    @Override
    public int update(Route route) {
        return routeMapper.update(route);
    }

    @Override
    public int query(String id) {
        return routeMapper.query(id);
    }

    @Override
    public List<Route> queryAll() {
        return routeMapper.queryAll();
    }
}
