package com.cg.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Entity.Account;
import com.cg.Entity.Transaction;
import com.cg.Service.TransactionService;
import com.cg.exception.TransactionException;
import com.cg.repository.AccountRepository;
import com.cg.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transrepo;
	@Autowired
	private AccountRepository accountrepo;

	@Override
	public Transaction createTransaction(Transaction transaction1, int accountId) throws TransactionException {
		Account account = accountrepo.findById(accountId)
				.orElseThrow(() -> new TransactionException("Account not found"));

		if (account == null) {
			throw new TransactionException("Account not found");
		}

		transaction1.setAccount(account);

		transrepo.save(transaction1);

		return transaction1;
	}

	@Override
	public HashSet<Transaction> getTransactionById(int accountId) throws TransactionException {

		Account account = accountrepo.findById(accountId)
				.orElseThrow(() -> new TransactionException("Account not found"));

		HashSet<Transaction> transactions = new HashSet<>(account.getTransaction());

		return transactions;
	}

}
