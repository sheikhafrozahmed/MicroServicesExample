package com.application.orderservice.repository;

import com.application.orderservice.bean.OrderInfo;

public interface OrderRepository {

	public OrderInfo getOrderInfoById(int id);
	
	public boolean insertOrder(OrderInfo orderInfo);
	
}
