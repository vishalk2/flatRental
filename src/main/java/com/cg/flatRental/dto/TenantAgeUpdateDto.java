package com.cg.flatRental.dto;

public class TenantAgeUpdateDto {
	
	private int userId;
	private int tenantAge;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTenantAge() {
		return tenantAge;
	}
	public void setTenantAge(int tenantAge) {
		this.tenantAge = tenantAge;
	}
}
