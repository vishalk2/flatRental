package com.cg.flatRental.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.cg.flatRental.secure.User;

@Entity
@Table(name="admin_info")
public class Admin extends User{
	
	@NotBlank(message = "Admin Name cannot be empty")
	private String adminName;
	
	@Min(value = 18, message = "Age must be greater than 18 years!")
	@Max(value = 120, message = "Age must not be greater than 120 years!")
	private int adminAge;
	
	private long adminContact;
	
	@NotBlank(message = "EmailId cannot be empty")
	@Email(message = "Not the proper Email ID format! enter again")
	private String adminEmailId;
	
	public Admin() {
	}

	public Admin(@NotBlank(message = "Admin Name cannot be empty") String adminName,
			@Min(value = 18, message = "Age must be greater than 18 years!") @Max(value = 120, message = "Age must not be greater than 120 years!") int adminAge,
			long adminContact,
			@NotBlank(message = "EmailId cannot be empty") @Email(message = "Not the proper Email ID format! enter again") String adminEmailId) {
		super();
		this.adminName = adminName;
		this.adminAge = adminAge;
		this.adminContact = adminContact;
		this.adminEmailId = adminEmailId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public long getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
}
