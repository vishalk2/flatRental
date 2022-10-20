package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.flatRental.secure.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tenant_info")
public class Tenant extends User{
	
	private String tenantName;
	
	private int tenantAge;
	
	private long tenantPhoneNumber;
	
	private String emailId;
	
	@OneToMany(mappedBy = "tenant")
	@JsonManagedReference("tenantBookingRequests")
	private List<BookingRequest> bookingReqs;
	
	public Tenant() {
	}
	
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
}
