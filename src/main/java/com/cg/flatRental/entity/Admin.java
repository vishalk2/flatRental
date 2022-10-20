package com.cg.flatRental.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cg.flatRental.secure.User;

@Entity
@Table(name="admin_info")
public class Admin extends User{
	
	private String adminName;
	
	private int adminAge;
	
	private long adminContact;
	
	private String adminEmailId;
	
	public Admin() {
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
