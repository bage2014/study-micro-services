package com.bage.study.micro.services.gateway.route.dao;

import com.bage.study.micro.services.gateway.route.domain.Route;

import java.util.List;

public interface RouteMapper {

    int insert(Route route);

    int delete(String id);

    int update(Route route);

    int query(String id);

    List<Route> queryAll();

}
