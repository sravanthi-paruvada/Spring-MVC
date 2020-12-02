package com.bankapp.model.dao;
import java.util.*;

import com.bankapp.model.entity.User;

public interface UserDao {

	public List<User> getAllUsers();
	public User updateUser(User user);
	public User delUser(String username,String password);
	public User addUser(User user);
	public User getUser(String username,String password);
}
