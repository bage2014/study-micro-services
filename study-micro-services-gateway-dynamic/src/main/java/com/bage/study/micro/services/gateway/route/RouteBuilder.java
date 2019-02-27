package com.bage.study.micro.services.gateway.route;

import com.bage.study.micro.services.gateway.route.domain.Filter;
import com.bage.study.micro.services.gateway.route.domain.Predicate;
import com.bage.study.micro.services.gateway.route.domain.Route;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.ArrayList;
import java.util.List;

public class RouteBuilder {


    public static Route fromRouteDefinition(RouteDefinition routeDefinition){
        Route route = new Route();
        route.setId(routeDefinition.getId());
        route.setUri(routeDefinition.getUri());

        List<PredicateDefinition> predicateDefinitions = routeDefinition.getPredicates();
        if (predicateDefinitions != null) {
            int n = predicateDefinitions.size();
            List<Predicate> list = new ArrayList<>(n);
            Predicate predicate = null;
            PredicateDefinition predicateDefinition = null;
            for (int i = 0; i < n; i++) {
                predicateDefinition = predicateDefinitions.get(i);
                predicate = new Predicate();
                predicate.setName(predicateDefinition.getName());
                predicate.setArgs(predicateDefinition.getArgs());
                list.add(predicate);
            }
            route.setPredicates(list);
        }

        List<FilterDefinition> filterDefinitions = routeDefinition.getFilters();
        if (filterDefinitions != null) {
            int n = filterDefinitions.size();
            List<Filter> list = new ArrayList<>(n);
            Filter filter = null;
            FilterDefinition filterDefinition = null;
            for (int i = 0; i < n; i++) {
                filterDefinition = filterDefinitions.get(i);
                filter = new Filter();
                filter.setName(filterDefinition.getName());
                filter.setArgs(filterDefinition.getArgs());
                list.add(filter);
            }
            route.setFilters(list);
        }
        return route;
    }

    public static List<RouteDefinition> toRouteDefinition(List<Route> routes){
        List<RouteDefinition> routeDefinitions = new ArrayList<>(routes.size());
        int n = routes.size();
        for (int i = 0; i < n; i++) {
            routeDefinitions.add(RouteBuilder.toRouteDefinition(routes.get(i)));
        }
        return routeDefinitions;
    }


    public static RouteDefinition toRouteDefinition(Route route){
        RouteDefinition definition = new RouteDefinition();
        definition.setId(route.getId());
        definition.setUri(route.getUri());

        List<Predicate> predicates = route.getPredicates();
        if (predicates != null) {
            int n = predicates.size();
            List<PredicateDefinition> list = new ArrayList<>(n);
            PredicateDefinition predicateDefinition = null;
            Predicate predicate = null;
            for (int i = 0; i < n; i++) {
                predicate = predicates.get(i);
                predicateDefinition = new PredicateDefinition();
                predicateDefinition.setName(predicate.getName());
                predicateDefinition.setArgs(predicate.getArgs());
                list.add(predicateDefinition);
            }
            definition.setPredicates(list);
        }

        List<Filter> filters = route.getFilters();
        if (filters != null) {
            int n = filters.size();
            List<FilterDefinition> list = new ArrayList<>(n);
            FilterDefinition filterDefinition = null;
            Filter filter = null;
            for (int i = 0; i < n; i++) {
                filter = filters.get(i);
                filterDefinition = new FilterDefinition();
                filterDefinition.setName(filter.getName());
                filterDefinition.setArgs(filter.getArgs());
                list.add(filterDefinition);
            }
            definition.setFilters(list);
        }
        return definition;
    }

}
