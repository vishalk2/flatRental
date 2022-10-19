package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tenant_info")
public class Tenant extends User{
	
//	@NotEmpty(message = "Tenant Name can't be empty!")
//	@Size(min = 3, max = 25, message = "Invalid Tenant name. Please enter a vaild Tenant name!")
//	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! Re-enter the name")
	private String tenantName;
	
//	@NotEmpty(message = "Tenant Age can't be empty!")
//	@Size(min = 1, max = 120, message = "Invalid Age. Please enter a vaild age.")
//	@Pattern(regexp = "^[1-9]$|^[1-9][0-9]$|^(100)$", message = "Invalid input:Enter numbers only")
	private int tenantAge;
	
//	@NotEmpty(message = "Phone Number can't be empty!")
//	@Size(min = 10, max = 10, message = "Invalid Phone Number. Please enter a vaild phone number of 10 digits")
//	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	private long tenantPhoneNumber;
	
//	@NotEmpty(message = "Email ID can't be empty!")
//	@Size(min = 2, max = 30, message = "Invalid Email ID. Please enter a vaild email ID")
//	@Email(message = "Not a proper Email ID format! Enter again")
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