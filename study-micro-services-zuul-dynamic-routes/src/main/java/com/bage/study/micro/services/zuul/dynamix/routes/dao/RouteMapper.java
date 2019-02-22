package com.bage.study.micro.services.zuul.dynamix.routes.dao;

import com.bage.study.micro.services.zuul.dynamix.routes.domain.Route;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteMapper {

    int insert(Route route);

    int delete(String id);

    int update(Route route);

    Route query(String id);

    List<Route> queryAll();

}
