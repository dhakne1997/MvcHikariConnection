package com.springboot.mvc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mvc.dao.Productdao;
import com.springboot.mvc.model.Product;
import com.springboot.mvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private Productdao productdao;

	@Override
	public List<Product> getAllProduct() {
		return productdao.findAll();
	}

	@Override
	public void save(Product product) {
		productdao.save(product);
	}

//	@Override
//	public Product getById(Integer id) {
//		Optional<Product> optional = productdao.findById(id);
//		Product product = null;
//		if (optional.isPresent())
//			product = optional.get();
//		else
//			throw new RuntimeException("Product not found for id : " + id);
//		return product;
//	}

}
