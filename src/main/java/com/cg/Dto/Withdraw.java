package com.cg.Dto;

public class Withdraw {
	private int accountId;
    private double withdrawAmount;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	@Override
	public String toString() {
		return "Withdraw [accountId=" + accountId + ", withdrawAmount=" + withdrawAmount + "]";
	}
	public Withdraw(int accountId, double withdrawAmount) {
		super();
		this.accountId = accountId;
		this.withdrawAmount = withdrawAmount;
	}
	public Withdraw() {
		super();
	}
    
	
}
