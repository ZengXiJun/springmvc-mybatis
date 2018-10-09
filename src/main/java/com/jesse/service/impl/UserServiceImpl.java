package com.jesse.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jesse.dao.UserMapper;
import com.jesse.model.User;
import com.jesse.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	public User getUserById(int userId) {
		
		return this.userMapper.selectByPrimaryKey(userId);
		
	}

}
