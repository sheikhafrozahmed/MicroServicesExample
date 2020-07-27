package com.application.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.orderservice.bean.OrderInfo;
import com.application.orderservice.proxy.OrderService;
import com.application.orderservice.repository.OrderRepository;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{id}")
	public OrderInfo getOrderInfoById(@PathVariable("id") int id){
		OrderInfo orderInfo = orderRepository.getOrderInfoById(id);
		orderInfo.setProducts(orderService.getProductById(orderInfo.getProduct()));	
		return orderInfo; 
	}
	
	
	@PostMapping(path="/", consumes = "application/json")
	public String insertOrder(@RequestBody OrderInfo orderInfo) {
		if(orderRepository.insertOrder(orderInfo)) {
			return "Ordered Added successfully";
		} else {
			return "Failed to place an order";
		}
	}

}
