package com.techelevator.tenmo.models;

public class Transfer {
	
	
	private Long transferId;
	private Long typeId;
	private Long statusId;
	private double amount;
	private Long accountFrom;
	private Long accountTo;
	
	
	public Long getTransferId() {
		return transferId;
	}
	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Long accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Long getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Long accountTo) {
		this.accountTo = accountTo;
	}
	@Override
	public String toString() {
		return "Transfer [transferId=" + transferId + ", typeId=" + typeId + ", statusId=" + statusId + ", amount="
				+ amount + ", accountFrom=" + accountFrom + ", accountTo=" + accountTo + "]";
	}
	
	
}
