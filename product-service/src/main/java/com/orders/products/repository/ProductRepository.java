package com.orders.products.repository;

import java.util.List;

import com.orders.products.bean.Product;

public interface ProductRepository {
	
	public List<Product> getProducts();
	
	public Product getProductById(int id);

	public boolean insertProduct(Product product);

}
