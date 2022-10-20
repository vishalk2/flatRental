package com.cg.flatRental.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flatRental.dto.APIError;
import com.cg.flatRental.exceptions.BookingRequestNotFoundException;
import com.cg.flatRental.exceptions.FlatAvailabilityException;
import com.cg.flatRental.exceptions.FlatBookingException;
import com.cg.flatRental.exceptions.FlatNotFoundException;
import com.cg.flatRental.exceptions.SocietyNotFoundException;
import com.cg.flatRental.exceptions.UserNotFoundException;

@RestControllerAdvice
public class FlatRentalExceptionHandler {
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
