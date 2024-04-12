package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.form.ProductForm;
import com.example.repo.ProductRepo;
import com.example.service.ProductService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepo productRepo;
	
	@Override
	public Product insertProduct(ProductForm form) {
		Product insertData=new Product();
		insertData.setName(form.getName());
		insertData.setPrice(form.getPrice());
		insertData.setQty(form.getQty());
		return productRepo.save(insertData);
	}

	@Override
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

}
