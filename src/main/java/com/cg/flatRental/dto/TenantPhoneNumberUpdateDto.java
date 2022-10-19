package com.cg.flatRental.dto;

public class TenantPhoneNumberUpdateDto {
	
	private int userId;
	private long tenantPhoneNumber;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getTenantPhoneNumber() {
		return tenantPhoneNumber;
	}
	public void setTenantPhoneNumber(long tenantPhoneNumber) {
		this.tenantPhoneNumber = tenantPhoneNumber;
	}
}
