package com.springboot.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mvc.dao.Productdao;
import com.springboot.mvc.model.Product;


public interface ProductService {
	public List<Product> getAllProduct();

	void save(Product product);

//	Product getById(Integer id);


}
