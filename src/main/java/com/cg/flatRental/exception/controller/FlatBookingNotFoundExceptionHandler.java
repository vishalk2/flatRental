package com.cg.flatRental.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flatRental.dto.APIError;
import com.cg.flatRental.exceptions.FlatBookingNotFoundException;

@RestControllerAdvice
public class FlatBookingNotFoundExceptionHandler {
	@ExceptionHandler(FlatBookingNotFoundException.class)
	public ResponseEntity<APIError> handler(Exception e){
		APIError error = new APIError("Flat booking not found", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
}
