package com.thaseen.pro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thaseen.pro.Entity.Customer;

public interface CustService {

	List<Customer> getAllCustomers();

	void saveCustomer(Customer cust);
	 
	Customer getCustomerById(long id);
	 
	void deleteCustomerById(long id);
	
}
