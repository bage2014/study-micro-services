package com.bage.study.micro.services.gateway.route.service;

import com.bage.study.micro.services.gateway.route.dao.MyRouteDefinitionRepository;
import com.bage.study.micro.services.gateway.route.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImp implements RouteService, ApplicationEventPublisherAware{

    private ApplicationEventPublisher publisher;

    @Autowired
    private MyRouteDefinitionRepository routeDefinitionRepository;

    @Override
    public void refresh() {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    public int insert(Route route) {
        int result = routeDefinitionRepository.insert(route);
        // refresh();
        return result;
    }

    @Override
    public int delete(String id) {
        int result = routeDefinitionRepository.delete(id);
        // refresh();
        return result;
    }

    @Override
    public int update(Route route) {
        int result = routeDefinitionRepository.update(route);
        // refresh();
        return result;
    }

    @Override
    public int query(String id) {
        return routeDefinitionRepository.query(id);
    }

    @Override
    public List<Route> queryAll() {
        return routeDefinitionRepository.queryAll();
    }
}