package com.bage.study.micro.services.zuul.dynamix.routes.service;

import com.bage.study.micro.services.zuul.dynamix.routes.dao.RouteMapper;
import com.bage.study.micro.services.zuul.dynamix.routes.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    RouteMapper routeMapper;

    List<Route> cacheList = new ArrayList<>();

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
    public Route query(String id) {
        return null;
    }

    @Override
    public List<Route> queryAll() {
        return routeMapper.queryAll();
    }

    @Override
    public List<Route> queryAllFromCache() {
        if(cacheList.isEmpty()){
            cacheList = queryAll();
        }
        return cacheList;
    }

    @Override
    public List<Route> refresh() {
        cacheList = routeMapper.queryAll();
        return cacheList;
    }

}
