package com.bankapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.AccountType;
import com.bankapp.model.entity.TxType;
import com.bankapp.model.service.aspects.Loggable;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;
	private TransactionLogService transactionLogService;
	
	private Logger logger= LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, TransactionLogService transactionLogService) {
		this.accountDao = accountDao;
		this.transactionLogService = transactionLogService;
	}

	@Override
	public List<Account> getAllAccounts() {
	 List<Account> accounts=accountDao.getAllAccounts();
	 return accounts;
	}

	@Loggable
	@Override
	public void deposite(int accountId, double amount) {
	Account account=accountDao.getAccountById(accountId);
	account.setBalance(account.getBalance()+amount);
	accountDao.updateAccount(account);
	transactionLogService.addTransactionLog(accountId,"Deposite amount", amount, TxType.DEPOSITE);
		
	}

	@Loggable
	@Override
	public void withdraw(int accountId, double amount) {
		Account account=accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance()-amount);
		accountDao.updateAccount(account);
		transactionLogService.addTransactionLog(accountId,"Withdraw amount", amount, TxType.WITHDRAW);
	}

	@Loggable
	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		
		withdraw(fromAccountId, amount);
		deposite(toAccountId, amount);
		transactionLogService.addTransactionLog(fromAccountId, "Transfer amount", amount, TxType.TRANSFER);
		
		
	}

	@Override
	public Account updateAccount(Account account) {
		Account accountToBeUpdated = accountDao.getAccountById(account.getAccountId());
		accountToBeUpdated.setEmail(account.getEmail());
		accountToBeUpdated.setPhone(account.getPhone());
		accountToBeUpdated.setAddress(account.getAddress());
		accountDao.updateAccount(accountToBeUpdated);
		
		return accountToBeUpdated;
		
	}

	@Override
	public void delAccount(int accountId) {
		
		accountDao.delAccount(accountId);
	}

	@Override
	public Account getAccountById(int accountId) {
		
		return accountDao.getAccountById(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		
		return accountDao.addAccount(account);
	}

}
