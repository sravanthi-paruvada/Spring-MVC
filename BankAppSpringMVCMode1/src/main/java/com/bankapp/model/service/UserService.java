package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	public User updateUser(User user);
	public User delUser(String username,String password);
	public User addUser(User user);
	public User getUser(String username,String password);
	
}
