package com.techelevator.tenmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.TransferDAO;

import com.techelevator.tenmo.model.Transfer;

@RestController
public class TransferController {

	@Autowired
	private TransferDAO transferDAO;

	public TransferController(TransferDAO transferDAO) {
		this.transferDAO = transferDAO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/transfers/{accountId}", method = RequestMethod.GET)
	public List<Transfer> list(@PathVariable Long accountId) {

		// int id = (int)authProvider.getCurrentUser().getId();
//		User user = new User();
//		user.
		List<Transfer> allTransfers = transferDAO.findTransferHistory(accountId);
		return allTransfers;
	}

	
	
	
	
	
	@RequestMapping(path = "/transfers/transferId/{id}", method = RequestMethod.GET)
	public Transfer returnTransferById(@PathVariable("id") Long transferId) {

		Transfer transfer = transferDAO.findTransferById(transferId);
		return transfer;
	}

}
