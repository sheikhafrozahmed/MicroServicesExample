package com.application.orderservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.application.orderservice.bean.Product;

@FeignClient(name="product-service", url="http://localhost:8282/products")
public interface OrderService {

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int id);
}
