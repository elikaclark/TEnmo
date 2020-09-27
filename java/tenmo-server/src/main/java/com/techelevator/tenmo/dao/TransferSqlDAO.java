package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Transfer;

@Component
public class TransferSqlDAO implements TransferDAO {

	private JdbcTemplate jdbcTemplate;

	public TransferSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Transfer> findAll() {
		List<Transfer> transfers = new ArrayList<>();
		String sql = "select * from transfers";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Transfer transfer = mapRowToTransfer(results);
			transfers.add(transfer);
		}

		return transfers;
	}

	@Override
	public Transfer findTransferById(Long transferId) {
		return jdbcTemplate.queryForObject("select * from transfers where transfer_id = ?", Transfer.class,
				transferId);
	}
	
	public List<Transfer> findTransferHistory(Long accId) {
		List<Transfer> transferHistory = new ArrayList<>();
		String sqlSearch = "select * from transfers where account_from = ? or account_to = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearch, accId, accId);
		while (result.next()) {
			Transfer transfersHistory = mapRowToTransfer(result);
			transferHistory.add(transfersHistory);
		}
		return transferHistory;
	}

	private Transfer mapRowToTransfer(SqlRowSet rs) {
		Transfer transfer = new Transfer();
		transfer.setTransferId(rs.getLong("transfer_id"));
		transfer.setTypeId(rs.getLong("transfer_type_id"));
		transfer.setStatusId(rs.getLong("transfer_status_id"));
		transfer.setAccountFrom(rs.getLong("account_from"));
		transfer.setAccountTo(rs.getLong("account_to"));
		transfer.setAmount(rs.getDouble("amount"));
		return transfer;
	}

}
