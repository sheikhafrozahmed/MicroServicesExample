package com.orders.products.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.products.bean.Product;
import com.orders.products.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public List<Product> getProducts(){
		return productRepository.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable ("id") @Valid @NotEmpty int id){
		return productRepository.getProductById(id);
	}
	
	@PostMapping(path="/", consumes = "application/json")
	public String insertProduct(@RequestBody Product product) {
		if(productRepository.insertProduct(product)) {
			return "Product Added successfully";
		} else {
			return "Failed to add Products into Database";
		}
	}
	
}
