package com.cg.Dto;

import jakarta.persistence.Column;

public class CustomerDto {

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String LastName;

	@Column(name = "user_Name")
	private String username;
	@Column(name = "password")
	private String password;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", LastName=" + LastName + ", username=" + username + ", password="
				+ password + "]";
	}

}
