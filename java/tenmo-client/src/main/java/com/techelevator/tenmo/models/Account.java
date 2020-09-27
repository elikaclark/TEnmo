package com.techelevator.tenmo.models;

public class Account {
	private Long accId;
	private Long userId;
	private double balance;
	
	
	@Override
	public String toString() {
		return "Account [accId=" + accId + ", userId=" + userId + ", balance=" + balance + "]";
	}
	public Long getAccId() {
		return accId;
	}
	public void setAccId(Long accId) {
		this.accId = accId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
