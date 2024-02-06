package com.cg.Service;

import org.springframework.stereotype.Service;

import com.cg.Entity.Customer;
import com.cg.exception.CustomerException;
@Service
public interface CustomerService {
	public Customer createCustomer(Customer customerD) throws CustomerException;

	Customer authenticateUser(String username, String password);
}
