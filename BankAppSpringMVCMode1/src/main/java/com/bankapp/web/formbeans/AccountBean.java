package com.bankapp.web.formbeans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountBean {
	
	private Integer accountId;

	@NotNull(message = "Account Name can not be left blank")
	private String name;

	@NotNull(message = "Select an account type ")
	private String accountType;

	@NotNull(message = "Address can not be left blank")
	private String address;

	@NotNull(message = "Phone number can not be left blank")
	private String phone;

	@NotNull(message = "Email can not be left blank")
	private String email;
	
	@NotNull(message = "Aadhar Card can not be left blank")
	private String aadharCard;
	
	@NotNull(message = "Pan Number can not be left blank")
	private String panNumber;
	
	@NotNull(message = "Pan Number can not be left blank")
	private Double balance;
	
	
//	balance
//	accountType
//	accountStatus
	

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
