package com.bankapp.web.formbeans;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransferBean {

	@NotNull(message = "Account Id cannot be null")
	private Integer fromAccountId;
	
	@NotNull(message = "Account Id cannot be null")
	private Integer toAccountId;
	
	@NotNull(message = "Account Id cannot be null")
	@Min(value = 50 ,message = "Minimum amount should not be less than 50")
	@Max(value = 5000,message = "Maximum amount should not exceed 5000")
	private double amount;
	
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Integer getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
