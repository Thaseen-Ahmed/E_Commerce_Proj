package com.thaseen.pro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thaseen.pro.Entity.Customer;


@Repository
public interface CustRepo extends JpaRepository<Customer, Long>{
	
	public Customer findByEmail(String email); 
}
