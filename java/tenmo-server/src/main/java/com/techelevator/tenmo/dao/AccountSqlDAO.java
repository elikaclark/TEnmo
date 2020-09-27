package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Account;

@Component
public class AccountSqlDAO implements AccountDAO {

	private JdbcTemplate jdbcTemplate;
	private double balance;

	public AccountSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		String sql = "select * from accounts";

		// 2 types of jdbcTemplate methods:
		// 1. queryForRowSet is for SELEC

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Account account = mapRowToAccount(results);
			accounts.add(account);
		}

		return accounts;

	}

	@Override
	public double getCurrentBalance() {
		// TODO Auto-generated method stub
		return 0.00;
	}

	@Override
	public double getBalanceByAccId(Long accId) {
		return jdbcTemplate.queryForObject("select balance from accounts where user_id = ?", Double.class, accId);

	}

	@Override
	public Account getAccountById(Long id) {
		Account account = null;
		String sql = "select * from accounts where user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

		while (results.next()) {
			account = mapRowToAccount(results);

		}
		return account;
	}

	@Override
	public double withdrawFrom(Long accId, double amount) {
		return jdbcTemplate.queryForObject("select balance from account where account_id = ?", Double.class, accId,
				amount);
	}

	@Override
	public double depositTo(Long accId, double amount) {
		return jdbcTemplate.queryForObject("select balance from account where account_id = ?", Double.class, accId,
				amount);
	}

	@Override
	public double makeTransfer(Long accId, Long accId1, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Account mapRowToAccount(SqlRowSet results) {

		Account account = new Account();
		account.setAccId(results.getLong("account_id"));
		account.setId(results.getLong("user_id"));
		account.setBalance(results.getDouble("balance"));

		return account;
	}

	@Override
	public Account updateAccount(Account account, Long id) {
		String sqlUpdateAccount = "update accounts set balance = ? where account_id = ?";
		jdbcTemplate.update(sqlUpdateAccount, account.getBalance(), id);
		return account;
	}

}
