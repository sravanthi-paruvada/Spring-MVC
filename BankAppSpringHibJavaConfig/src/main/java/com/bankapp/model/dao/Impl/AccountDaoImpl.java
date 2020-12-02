package com.bankapp.model.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.exception.AccountNotFoundException;
import com.bankapp.model.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	
	private SessionFactory factory;
	
	
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}



	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	
	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("select a from Account a").list();
	}

	@Override
	public Account updateAccount(Account account) {
		getSession().update(account);
		return account;
	}

	@Override
	public Account delAccount(int accountId) {
		Account accountTobeDel=getAccountById(accountId);
		getSession().delete(accountTobeDel);
		return accountTobeDel;
	}

	@Override
	public Account getAccountById(int accountId) {
		Account account=getSession().find(Account.class, accountId);
		if(account==null)
			throw new AccountNotFoundException("Account "+accountId+" is not found");
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		getSession().persist(account);
		return account;
	}

}
