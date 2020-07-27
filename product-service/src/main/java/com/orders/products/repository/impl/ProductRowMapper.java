package com.orders.products.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orders.products.bean.Product;

public class ProductRowMapper implements RowMapper<Product>{
	
	public Product mapRow(ResultSet resultSet, int i) throws SQLException {
		Product product = new Product();
		product.setId(resultSet.getInt("id"));
		product.setName(resultSet.getString("name"));
		product.setQuantity(resultSet.getInt("quantity"));
		return product;
	}

}
