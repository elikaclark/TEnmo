package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfer;

public interface TransferDAO {

	List<Transfer> findAll();

	Transfer findTransferById(Long transferId);

	public List<Transfer> findTransferHistory(Long accId);
}
