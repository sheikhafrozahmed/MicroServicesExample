package com.orders.products.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.orders.products.exception.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public final ResponseEntity<Object> handleMethodArgumentTypeMismatchExceptions(
			MethodArgumentTypeMismatchException ex) {
	    String exceptionResponse = String.format("Failed to convert provide input value to required type", ex.getMessage());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
