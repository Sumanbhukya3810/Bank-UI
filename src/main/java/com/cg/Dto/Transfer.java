package com.cg.Dto;

public class Transfer {
	private int fromAccountNumber;
	private int toAccountNumber;
    private float transferAmount;
    
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transfer(int fromAccountNumber, int toAccountNumber, float transferAmount) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transferAmount = transferAmount;
	}
	public int getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(int fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public int getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(int toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public float getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}
	@Override
	public String toString() {
		return "Transfer [fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber
				+ ", transferAmount=" + transferAmount + "]";
	}
	
}
