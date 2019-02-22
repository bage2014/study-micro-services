package com.bage.study.micro.services.zuul.dynamix.routes.service;

import com.bage.study.micro.services.zuul.dynamix.routes.domain.Route;

import java.util.List;

public interface RouteService {

    int insert(Route route);

    int delete(String id);

    int update(Route route);

    Route query(String id);

    List<Route> queryAll();

    List<Route> queryAllFromCache();

    List<Route> refresh();

}
