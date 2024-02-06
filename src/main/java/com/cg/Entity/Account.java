package com.cg.Entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private int accountId;

	
	@Column(name = "current_Balance")
	private double currentBalance;

	@Column(name = "account_Type")
	private String accountType;
	
	@OneToOne
	private Customer customer;
	

	@OneToMany(mappedBy="account",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Transaction> transaction = new HashSet<>();
	
	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, double currentBalance, String accountType, Customer customer,
			Set<Transaction> transaction) {
		super();
		this.accountId = accountId;
		this.currentBalance = currentBalance;
		this.accountType = accountType;
		this.customer = customer;
		this.transaction = transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", currentBalance=" + currentBalance + ", accountType=" + accountType
				+ ", customer=" + customer + ", transaction=" + transaction + "]";
	}

	

	

	
}
