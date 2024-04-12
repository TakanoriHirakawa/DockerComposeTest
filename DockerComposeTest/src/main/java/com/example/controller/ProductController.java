package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Product;
import com.example.form.ProductForm;
import com.example.service.impl.ProductServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class ProductController {
	
	private final ProductServiceImpl productService;
	
	@GetMapping("/products/findAll")
	public String getAllProducts(Model model){
		List<Product>list = productService.getProducts();
		model.addAttribute("productList",list);
		return "views/view";
	}
	
	@GetMapping("/products/Insert")
	public String getInsert(Model model) {
		model.addAttribute("insertData", new ProductForm());
		return "views/insert";
	}
	
	@PostMapping("/products/insert")
	public String postInsert(Model model,@ModelAttribute("insertData")ProductForm form) {
		productService.insertProduct(form);
		model.addAttribute("productList",productService.getProducts());
		return "views/view";
	}
	
	@GetMapping("/index")
	public String getIdnex() {
		return "views/index";
	}

}
