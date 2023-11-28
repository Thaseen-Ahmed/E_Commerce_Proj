package com.thaseen.pro.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thaseen.pro.Entity.Customer;
import com.thaseen.pro.Repo.CustRepo;

@Service
public class CustServiceImpl implements CustService{

	@Autowired
	private CustRepo custre;
	
	
	@Override
	public List<Customer> getAllCustomers() {

		return custre.findAll();
	}

	@Override
	public void saveCustomer(Customer cust) {
		this.custre.save(cust);
	}

	@Override
	public Customer getCustomerById(long id) {
		
		Optional<Customer> option = custre.findById(id);
		Customer cust = null;
		
		if(option.isPresent()){
			cust = option.get();
			
		}
		else {
			throw new RuntimeException("User not found for id :: "+id);
			
		}
 			
		return cust;
	}

	@Override
	public void deleteCustomerById(long id) {
	
		this.custre.deleteById(id);
		
	}

}
