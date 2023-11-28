package com.thaseen.pro.Service;

import java.util.List;

import com.thaseen.pro.Entity.Customer;
import com.thaseen.pro.Entity.Product;

public interface ProService {

	List<Product> viewAllProduct();
	
	public Product saveProduct(Product product);
	 
	Product getProductById(long id);
	 
	void deleteProductById(long id);
	
	
}
