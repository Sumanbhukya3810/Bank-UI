package com.cg.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@NotNull(message = "CustId cannot be null")
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String LastName;
	
	@Column(name="user_Name")
	private String userName;
	@Column(name="password")
	private String password;
	 @OneToOne(mappedBy="customer")
	
	    private Account account;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String firstName, String lastName, String userName, String password, Account account) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		LastName = lastName;
		this.userName = userName;
		this.password = password;
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
	    return "Customer [custId=" + custId + ", firstName=" + firstName + ", LastName=" + LastName + ", userName="
	            + userName +",  password=" + password +" , account=" + (account != null ? account.getAccountId() : "null") + "]";
	}
	

	
}
