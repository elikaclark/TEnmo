package com.techelevator.tenmo.model;

public class Account {
	

	private Long accId;
	private Long id;
	private double balance;
	
	public Account() { } 
	
	public Account (Long accId, Long id, double balance) {
		this.accId = accId;
		this.id = id;
		this.balance = balance;
		
	}
	
	@Override
	public String toString() {
		return "Account [accId=" + accId + ", id=" + id + ", balance=" + balance + "]";
	}
	public Long getAccId() {
		return accId;
	}
	public void setAccId(Long accId) {
		this.accId = accId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
