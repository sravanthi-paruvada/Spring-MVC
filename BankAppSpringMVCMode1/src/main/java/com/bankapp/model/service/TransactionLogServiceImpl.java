package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.TxType;

@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{

	private TransactionLogDao transactionLogDao;
	
	@Autowired
	public TransactionLogServiceImpl(TransactionLogDao transactionLogDao) {
		this.transactionLogDao = transactionLogDao;
	}

	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txType) {
		return transactionLogDao.addTransactionLog(accountId,txInfo, amount, txType);
	}

	@Override
	public List<TransactionLog> getAllTransactions() {
		return transactionLogDao.getAllTransactions();
	}

	@Override
	public List<TransactionLog> getTransactionLogsForAnAccount(int accountId) {
		return transactionLogDao.getTransactionLogsForAnAccount(accountId);
	}

}
