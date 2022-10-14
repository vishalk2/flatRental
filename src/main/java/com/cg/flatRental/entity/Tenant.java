package com.cg.flatRental.entity;

public class Tenant {

	private int tenantId;
	private String tenantName;
	private int tenantAge;
	private long tenantPhoneNumber;
	
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public int getTenantAge() {
		return tenantAge;
	}
	public void setTenantAge(int tenantAge) {
		this.tenantAge = tenantAge;
	}
	public long getTenantPhoneNumber() {
		return tenantPhoneNumber;
	}
	public void setTenantPhoneNumber(long tenantPhoneNumber) {
		this.tenantPhoneNumber = tenantPhoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	private String emailId;
	
}
