package com.bage.study.micro.services.organization.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bage.study.micro.services.organization.user.dao.UserDao;
import com.bage.study.micro.services.organization.user.dao.UserMapper;
import com.bage.study.micro.services.organization.user.domain.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	UserMapper userMapper;
	
	public User getUserById(String id){
		return userDao.getUserById(id);
	}

	public List<User> queryAll() {
		return userMapper.queryAll();
	}
}
