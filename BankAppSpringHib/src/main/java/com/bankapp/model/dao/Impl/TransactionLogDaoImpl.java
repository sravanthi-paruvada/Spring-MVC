package com.bankapp.model.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.TxType;

@Repository
public class TransactionLogDaoImpl implements TransactionLogDao{

private SessionFactory factory;
	
	@Autowired
	public TransactionLogDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}



	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txType) {
		TransactionLog log=new TransactionLog(txInfo, amount, txType);
		getSession().persist(log);
		return null;
	}

	@Override
	public List<TransactionLog> getAllTransactions() {
		
		return getSession().createQuery("select t from TransactionLog t").list();
	}

	@Override
	public List<TransactionLog> getTransactionLogsForAnAccount(int accountId) {
	TransactionLog log=getSession().find(TransactionLog.class, accountId);
		return (List<TransactionLog>) log;
	}

}
