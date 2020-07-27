package com.application.orderservice.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.application.orderservice.bean.OrderInfo;

public class OrderRowMapper implements RowMapper<OrderInfo>{
	
	public OrderInfo mapRow(ResultSet resultSet, int i) throws SQLException {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(resultSet.getInt("id"));
		orderInfo.setName(resultSet.getString("name"));
		orderInfo.setDate(resultSet.getDate("order_date"));
		orderInfo.setAddress(resultSet.getString("address"));
		orderInfo.setProduct(resultSet.getInt("product_id"));
		orderInfo.setPrice(resultSet.getInt("price"));
		return orderInfo;
	}

}
