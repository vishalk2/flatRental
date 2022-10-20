package com.cg.flatRental.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin_info")
public class Admin extends User{
	
	@NotEmpty(message = "Admin Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Admin name. Please enter a vaild name!")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! Re-enter the name")
	private String adminName;
	
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number. Please enter a vaild phone number of 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	private long adminContact;
	
	public Admin() {
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public long getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}
}
