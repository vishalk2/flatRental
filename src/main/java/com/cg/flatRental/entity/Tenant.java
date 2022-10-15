package com.cg.flatRental.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tenant_info")
public class Tenant extends User {

	
	private String tenantName;
	private int tenantAge;
	private long tenantPhoneNumber;
	public Tenant() {}
	public Tenant(String tenantName, int tenantAge, long tenantPhoneNumber, String emailId) {
		super();
		
		this.tenantName = tenantName;
		this.tenantAge = tenantAge;
		this.tenantPhoneNumber = tenantPhoneNumber;
		this.emailId = emailId;
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
