package com.cg.Service;

import org.springframework.stereotype.Service;

import com.cg.Entity.Account;
import com.cg.exception.AccountException;

@Service
public interface AccountService {
	public Account createAccount(Account account) throws AccountException;

	public Account searchById(int accountId) throws AccountException;;

	public String deposit(int accountId, double depositAmount) throws AccountException;

	public String withdraw(int accountNumber, double withdrawAmount) throws AccountException;

	public String transfer(int fromAccountNumber, int toAccountNumber, float transferAmount) throws AccountException;

}
