package com.orders.products.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orders.products.bean.Product;
import com.orders.products.exception.ProductNotFoundException;
import com.orders.products.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCTS";
	
	private final String GET_PRODUCT_BY_ID = "SELECT * FROM PRODUCTS WHERE ID = ? ";
	
	private final String INSERT_PRODUCT = "INSERT INTO PRODUCTS (NAME, QUANTITY) VALUES (?,?)";
	
	@Override
	public List<Product> getProducts(){
		return jdbcTemplate.query(GET_ALL_PRODUCTS, new ProductRowMapper());
	}
	
	@Override
	public Product getProductById(int id) {
		Product product = null;
		try {
			product = jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new Object[] {id}, new ProductRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			throw new ProductNotFoundException();
		}
		return product;
	}

	@Override
	public boolean insertProduct(Product product) {
		return jdbcTemplate.update(INSERT_PRODUCT, product.getName(), product.getQuantity()) > 0;
		
	}

}
