package com.springboot.mvc.dao;


import java.util.List;
import java.util.Optional;

import com.springboot.mvc.model.Product;

public interface Productdao {
	

	public List<Product> findAll();

	public int save(Product product);

//	public Optional<Product> findById(Integer id);
}
