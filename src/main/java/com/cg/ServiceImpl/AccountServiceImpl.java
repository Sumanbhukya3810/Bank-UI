package com.cg.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Entity.Account;
import com.cg.Service.AccountService;
import com.cg.exception.AccountException;
import com.cg.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountrepo;

	public Account createAccount(Account account) throws AccountException {
		if (account == null) {
			throw new AccountException("Invalid account data");
		}

		accountrepo.save(account);

		return account;
	}

	@Override
	public String deposit(int accountId, double depositAmount) throws AccountException {
		Account account = accountrepo.findById(accountId).orElseThrow(() -> new AccountException("Account not found"));

		double currentBalance = account.getCurrentBalance();
		double newBalance = currentBalance + depositAmount;
		account.setCurrentBalance(newBalance);

		accountrepo.save(account);

		return "Deposit successful. New balance: " + newBalance;

	}

	@Override
	public String withdraw(int accountNumber, double withdrawAmount) throws AccountException {
		Account account = accountrepo.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account not found"));
		double currentBalance = account.getCurrentBalance();

		double newBalance = currentBalance - withdrawAmount;

		account.setCurrentBalance(newBalance);
		accountrepo.save(account);
		return "withdraw successful. New balance: " + newBalance;
	}

	@Override
	public String transfer(int fromAccountNumber, int toAccountNumber, float transferAmount) throws AccountException {
		Account fromAccount = accountrepo.findById(fromAccountNumber)
				.orElseThrow(() -> new AccountException("Source account not found"));

		Account toAccount = accountrepo.findById(toAccountNumber)
				.orElseThrow(() -> new AccountException("Destination account not found"));

		if (fromAccount.getCurrentBalance() < transferAmount) {
			throw new AccountException("Insufficient balance in the source account");
		}

		fromAccount.setCurrentBalance(fromAccount.getCurrentBalance() - transferAmount);

		toAccount.setCurrentBalance(toAccount.getCurrentBalance() + transferAmount);

		accountrepo.save(fromAccount);
		accountrepo.save(toAccount);

		return "Transfer successful. New balance in source account: " + fromAccount.getCurrentBalance()
				+ ". New balance in destination account: " + toAccount.getCurrentBalance();

	}

	@Override
	public Account searchById(int accountId) throws AccountException {
		Optional<Account> optionalAccount = accountrepo.findById(accountId);

		if (optionalAccount.isPresent()) {
			return optionalAccount.get();
		} else {
			throw new AccountException("Account not found");
		}
	}
}
