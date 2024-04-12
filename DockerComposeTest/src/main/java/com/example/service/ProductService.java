package com.example.service;

import java.util.List;

import com.example.entity.Product;
import com.example.form.ProductForm;


public interface ProductService {
	
	Product insertProduct(ProductForm productForm);
	
	List<Product> getProducts();
}
