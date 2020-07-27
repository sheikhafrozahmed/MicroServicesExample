package com.application.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.application.orderservice.exception.OrderNotFoundException;

@ControllerAdvice
public class OrderExceptionHandler {
	
	@ExceptionHandler(value = OrderNotFoundException.class)
	   public ResponseEntity<Object> exception(OrderNotFoundException exception) {
	      return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public final ResponseEntity<Object> handleMethodArgumentTypeMismatchExceptions(
			MethodArgumentTypeMismatchException ex) {
	    String exceptionResponse = String.format("Failed to convert provide input value to required type", ex.getMessage());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
