package com.bankapp.model.dao.exception;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -318885350022544307L;

	public AccountNotFoundException(String message) {
		super(message);
		
	}
	
	

}
