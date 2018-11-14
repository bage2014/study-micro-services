package com.bage.study.micro.services.organization.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bage.study.micro.services.organization.user.dao.UserDao;
import com.bage.study.micro.services.organization.user.domain.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;
	
	public User getUserById(String id){
		return userDao.getUserById(id);
	}
}
