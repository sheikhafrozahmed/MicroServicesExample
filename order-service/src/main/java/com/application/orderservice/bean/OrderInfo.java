package com.application.orderservice.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderInfo {

	private int id;
	
	private String name;
	
	private String address;
	
	private Date date;
	
	private int product;
	
	private Product products;
	
	private int price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}
	
	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

		
}
