package com.bankapp.model.dao.Impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.dao.exception.UserNotFoundException2;
import com.bankapp.model.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	private SessionFactory factory;
	
	
	@Autowired
	public UserDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}



	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	@Override
	public List<User> getAllUsers() {
		return getSession().createQuery("select u from User u").list();
		
	}

	@Override
	public User updateUser(User user) {
	getSession().update(user);
	return user;
	}

	@Override
	public User delUser(String username,String password) {
		User userToBeDeleted=getUser(username, password);
		getSession().delete(userToBeDeleted);
		return userToBeDeleted;
	}

	@Override
	public User addUser(User user) {
		getSession().persist(user);
		return user;
	}

	@Override
	public User getUser(String username, String password) {
		Query getuser = getSession().createQuery("from User where username=:username1 and password=:password1");
		getuser.setParameter("username1", username);
		getuser.setParameter("password1", password);
		User user = (User)  getuser.getSingleResult();
		if(user==null)
			throw new UserNotFoundException2("User "+username+" not found");
		return user;
	}



}
