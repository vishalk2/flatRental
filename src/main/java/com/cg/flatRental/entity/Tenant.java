package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.flatRental.secure.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tenant_info")
public class Tenant extends User{
	
	@NotBlank(message = "Landlord Name cannot be empty")
	private String tenantName;
	
	@Min(value = 18, message = "Age must be greater than 18 years!")
	@Max(value = 120, message = "Age must not be greater than 120 years!")
	private int tenantAge;
	
	private long tenantPhoneNumber;
	
	@NotBlank(message = "EmailId cannot be empty")
	@Email(message = "Not the proper Email ID format! enter again")
	private String emailId;
	
	@OneToMany(mappedBy = "tenant")
	@JsonManagedReference("tenantBookingRequests")
	private List<BookingRequest> bookingReqs;
	
	public Tenant() {
	}

	public Tenant(@NotBlank(message = "Landlord Name cannot be empty") String tenantName,
			@Min(value = 18, message = "Age must be greater than 18 years!") @Max(value = 120, message = "Age must not be greater than 120 years!") int tenantAge,
			long tenantPhoneNumber,
			@NotBlank(message = "EmailId cannot be empty") @Email(message = "Not the proper Email ID format! enter again") String emailId,
			List<BookingRequest> bookingReqs) {
		super();
		this.tenantName = tenantName;
		this.tenantAge = tenantAge;
		this.tenantPhoneNumber = tenantPhoneNumber;
		this.emailId = emailId;
		this.bookingReqs = bookingReqs;
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
