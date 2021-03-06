package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.UserMapper;
import com.sm.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	};

    public int insert(User record) {
    	return userMapper.insert(record);
    };

    public int insertSelective(User record) {
    	return userMapper.insertSelective(record);
    };

    public User selectByPrimaryKey(Integer id) {
    	return userMapper.selectByPrimaryKey(id);
    };

    public int updateByPrimaryKeySelective(User record) {
    	return userMapper.updateByPrimaryKeySelective(record);
    };

    public int updateByPrimaryKey(User record) {
    	return userMapper.updateByPrimaryKey(record);
    };
    
    
}
