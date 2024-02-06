package com.cg.Service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.cg.Entity.Transaction;
import com.cg.exception.TransactionException;
@Service
public interface TransactionService {
	public Transaction createTransaction(Transaction transaction1,int accountId)throws TransactionException;

	public HashSet<Transaction> getTransactionById(int accountId)throws TransactionException;


}
