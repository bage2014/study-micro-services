package com.bage.study.micro.services.gateway.route.dao;

import com.bage.study.micro.services.gateway.route.domain.Route;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteDaoImp implements RouteMapper {

    List<Route> list = new ArrayList<>();

    @Override
    public int insert(Route route){
        return list.add(route) ? 1 : 0;
    }
    @Override
    public int delete(String id){
        Route route = new Route();
        route.setId(id);
        return list.remove(route) ? 1 : 0;
    }

    @Override
    public int update(Route route) {
        list.set(list.indexOf(route),route);
        return 1;
    }

    @Override
    public int query(String id) {
        Route route = new Route();
        route.setId(id);
        return list.indexOf(id);
    }

    @Override
    public List<Route> queryAll(){
        return list;
    }

}
