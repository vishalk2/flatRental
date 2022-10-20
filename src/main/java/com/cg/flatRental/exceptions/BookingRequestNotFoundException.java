package com.cg.flatRental.exceptions;

public class BookingRequestNotFoundException extends Exception {
	public BookingRequestNotFoundException() {
	}
	public BookingRequestNotFoundException(String msg) {
		super(msg);
	}
}
