package com.bage.study.micro.services.gateway.route.service;

import com.bage.study.micro.services.gateway.route.domain.Route;

import java.util.List;

public interface RouteService {

    int insert(Route route);

    int delete(String id);

    int update(Route route);

    int query(String id);

    List<Route> queryAll();

    void refresh();
}
