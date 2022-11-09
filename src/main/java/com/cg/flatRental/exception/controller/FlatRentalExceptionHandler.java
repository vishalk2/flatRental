package com.cg.flatRental.exception.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cg.flatRental.dto.APIError;
import com.cg.flatRental.exceptions.BookingRequestNotFoundException;
import com.cg.flatRental.exceptions.FlatAvailabilityException;
import com.cg.flatRental.exceptions.FlatBookingException;
import com.cg.flatRental.exceptions.FlatNotFoundException;
import com.cg.flatRental.exceptions.SocietyNotFoundException;
import com.cg.flatRental.exceptions.UserNotFoundException;

@RestControllerAdvice
public class FlatRentalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException e){
		Map<String, String> resp = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException e){
		String msg = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
		if(msg.contains("user_name")) {
			APIError error = new APIError("Username already exists. Try again!",409);
			return new ResponseEntity<>(error, HttpStatus.CONFLICT);
		}
		APIError error = new APIError("Credentials already exist. Try again!",409);
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(BookingRequestNotFoundException.class)
	public ResponseEntity<APIError> handleBookingRequests(Exception e){
		APIError error = new APIError("Booking Requests not found", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FlatAvailabilityException.class)
	public ResponseEntity<APIError> handleFlatAvailability(Exception e){
		APIError error = new APIError("Flat unavailable", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FlatBookingException.class)
	public ResponseEntity<APIError> handleFlatBooking(Exception e){
		APIError error = new APIError("Flat Booking not processed", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FlatNotFoundException.class)
	public ResponseEntity<APIError> handleFlatNotFoundException(Exception e){
		APIError error = new APIError("Flat details not found", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SocietyNotFoundException.class)
	public ResponseEntity<APIError> handleSocietyNotFoundException(Exception e){
		APIError error = new APIError("Society details not found", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<APIError> handleUserNotFoundException(Exception e){
		APIError error = new APIError("User details not found", 404);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
}
