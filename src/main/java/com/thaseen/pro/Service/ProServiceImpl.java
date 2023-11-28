package com.thaseen.pro.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thaseen.pro.Entity.Product;
import com.thaseen.pro.Repo.ProRepo;
@Service
public class ProServiceImpl implements ProService{

	@Autowired
	private ProRepo prorepo;
	
	@Override
	public List<Product> viewAllProduct() {
		
		return (List<Product>) prorepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return this.saveProduct(product);
		
	}

	@Override
	public Product getProductById(long id) {
		
		Optional<Product> option = prorepo.findById(id);
		Product prod = null;
		
		if(option.isPresent()){
			prod = option.get();
			
		}
		else {
			throw new RuntimeException("Product not found for id :: "+id);
			
		}
 			
		return prod;
	}

	@Override
	public void deleteProductById(long id) {
	
		this.prorepo.deleteById(id);
	}

}
