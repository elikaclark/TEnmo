package com.techelevator.tenmo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.model.Account;

@RestController
public class AccountController {

	@Autowired
	private AccountDAO accountDAO;

	public AccountController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/users/{id}/account", method = RequestMethod.GET)
	public Account getUserAccount(@PathVariable Long id) {

		return accountDAO.getAccountById(id);

	}

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public List<Account> list() {

		List<Account> allAccounts = accountDAO.findAll();
		return allAccounts;
	}

	@RequestMapping(path = "/accounts/{id}", method = RequestMethod.GET)
	public double returnBalanceByAccId(@PathVariable("id") Long accId) {

		double balance = accountDAO.getBalanceByAccId(accId);
		return balance;
	}

	@RequestMapping(path = "/users/{id}/account", method = RequestMethod.PUT)
	public Account updateAccount(@Valid @RequestBody Account account, @PathVariable Long id) {
		Account output = accountDAO.updateAccount(account, id);
		return output;
	}

}
