package com.jwttoken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwttoken.model.Product;
import com.jwttoken.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/get")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		
		return productRepository.save(product);
		
	}

}
