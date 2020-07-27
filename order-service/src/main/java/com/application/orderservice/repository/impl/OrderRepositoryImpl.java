package com.application.orderservice.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.application.orderservice.bean.OrderInfo;
import com.application.orderservice.exception.OrderNotFoundException;
import com.application.orderservice.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String GET_ORDERS_BY_ID = "SELECT * FROM ORDERS WHERE ID = ? ";
	
	private final String INSERT_ORDERS = "INSERT INTO ORDERS (NAME,ADDRESS,PRODUCT_ID,PRICE) VALUES (?,?,?,?)";
	
	@Override
	public OrderInfo getOrderInfoById(int id) {
		OrderInfo orderInfo = null;
		try {
			orderInfo = jdbcTemplate.queryForObject(GET_ORDERS_BY_ID, new Object[] {id}, new OrderRowMapper());
		} catch(EmptyResultDataAccessException ex) {
			throw new OrderNotFoundException();
		}
		return orderInfo;
	}

	@Override
	public boolean insertOrder(OrderInfo orderInfo) {
		
		return jdbcTemplate.update(INSERT_ORDERS, 
				orderInfo.getName(),orderInfo.getAddress(),
				orderInfo.getProduct(),orderInfo.getPrice())> 0;
	}
	

}
