package com.cg.Dto;

public class Trasaction {
	private int accountId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Trasaction [accountId=" + accountId + "]";
	}
	
	
}
