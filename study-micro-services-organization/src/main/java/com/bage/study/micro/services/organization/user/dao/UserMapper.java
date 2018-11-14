package com.bage.study.micro.services.organization.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bage.study.micro.services.organization.user.domain.User;

@Mapper
public interface UserMapper {

    List<User> queryAll();

}
