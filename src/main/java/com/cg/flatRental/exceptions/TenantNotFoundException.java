package com.cg.flatRental.exceptions;

public class TenantNotFoundException extends Exception {
	
	public TenantNotFoundException() {
	}
	
	public TenantNotFoundException(String msg) {
		super(msg);
	}
}
