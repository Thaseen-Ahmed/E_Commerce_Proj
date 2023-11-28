package com.thaseen.pro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.thaseen.pro.Entity.Product;

public interface ProRepo extends CrudRepository<Product, Long>{

}
