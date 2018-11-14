package com.bage.study.micro.services.organization.user.dao;

import com.bage.study.micro.services.organization.user.domain.User;

public interface UserDao {

    User getUserById(String id);

}