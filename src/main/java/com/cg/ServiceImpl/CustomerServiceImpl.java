package com.cg.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Entity.Customer;
import com.cg.Service.CustomerService;
import com.cg.exception.CustomerException;
import com.cg.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerrepo;
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		if (customer == null) {
			throw new CustomerException("Invalid account data");
		}

		customerrepo.save(customer);

		return customer;	
	}
	@Override
	public Customer authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
	        return customerrepo.findByUsernameAndPassword(username, password);
	    }
	

	
}
