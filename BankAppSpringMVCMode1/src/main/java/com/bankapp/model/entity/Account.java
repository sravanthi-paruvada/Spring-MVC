package com.bankapp.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "account_table")
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int accountId;
	
		@Column( nullable = false)
		private String name;
		
		private Double balance;
		@Column( nullable = false)
		private String address;
		@Column( nullable = false)
		private String phone;
		@Column( nullable = false)
		private String email;
		@Column(unique = true, nullable = false)
		private String aadharCard;
		@Column(unique = true, nullable = false)
		private String panNumber;
		
		@Enumerated(EnumType.STRING)
		private AccountType accountType;
		
		@JoinColumn(name = "accountId_FK")
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		private List<TransactionLog> transactionLog=new ArrayList<>();
		
		private AccountStatus accountStatus= AccountStatus.ACTIVE;
		
		public Account() {}
		
		public Account(String name, Double balance, String address, String phone, String email, String aadharCard,
				String panNumber) {
		
			this.name = name;
			this.balance = balance;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.aadharCard = aadharCard;
			this.panNumber = panNumber;
		}
		
		

		public Account(String name, Double balance, String address, String phone, String email, String aadharCard,
				String panNumber, AccountType accountType) {
			
			this.name = name;
			this.balance = balance;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.aadharCard = aadharCard;
			this.panNumber = panNumber;
			this.accountType = accountType;
			
		}

		public Integer getAccountId() {
			return accountId;
		}
		public void setAccountId(Integer accountId) {
			this.accountId = accountId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(Double balance) {
			this.balance = balance;
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
		public List<TransactionLog> getTransactionLog() {
			return transactionLog;
		}
		public void setTransactionLog(List<TransactionLog> transactionLog) {
			this.transactionLog = transactionLog;
		}

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}

	
		

}
