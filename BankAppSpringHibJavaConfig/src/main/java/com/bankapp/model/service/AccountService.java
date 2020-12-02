package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.Account;

public interface AccountService {
	
	public List<Account> getAllAccounts();
	public void deposite(int accountId,double amount);
	public void withdraw(int accountId,double amount);
	public void transfer(int fromAccountId, int toAccountId,double amount);
	public void updateAddress(int accountid,String address,String phone,String email);
	public Account delAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);

}
