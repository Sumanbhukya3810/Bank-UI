package com.cg.Dto;

public class Deposit {
	private int accountId;
    private double depositAmount;
    
	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	@Override
	public String toString() {
		return "Deposit [accountId=" + accountId + ", depositAmount=" + depositAmount + "]";
	}
	public Deposit(int accountId, double depositAmount) {
		super();
		this.accountId = accountId;
		this.depositAmount = depositAmount;
	}

}
