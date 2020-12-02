package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUsers() {
	
		return userDao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	@Override
	public User delUser(String username,String password) {
		
		return userDao.delUser(username, password);
	}

	@Override
	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		
		return userDao.getUser(username, password);
	}
	
	
	
	

}
