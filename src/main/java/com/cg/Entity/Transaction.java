package com.cg.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trasaction_id")
	private int transactionId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "transaction_Amount")
	private double transactionAmount;
	
	@Column(name = "transaction_Type")
	private String transactionType;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "transaction_Date")
	private LocalDate transactionDate;

	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
	    return "Transaction [trasactionId=" + transactionId + ", description=" + description +
	            ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType +
	            ", account=" + (account != null ? account.getAccountId() : "null") +
	            ", transactionDate=" + transactionDate + "]";

	
	}
	
	
}


