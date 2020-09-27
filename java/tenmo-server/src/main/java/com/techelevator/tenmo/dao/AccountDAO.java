package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {

	List<Account> findAll();

	double getCurrentBalance();

	double getBalanceByAccId(Long accId);

	Account getAccountById(Long id);

	double withdrawFrom(Long accId, double amount);

	double depositTo(Long accId, double amount);
	
	double makeTransfer(Long accId, Long accId1, double amount);

	Account updateAccount(Account account, Long id);
}
