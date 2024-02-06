package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT c FROM Customer c WHERE c.userName = :username AND c.password = :password")
	Customer findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


}
