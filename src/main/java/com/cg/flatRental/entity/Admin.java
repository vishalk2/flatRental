package com.cg.flatRental.entity;

public class Admin {
	private int adminId;
	private String adminPass;
	
	public Admin() {
	}
	
	public Admin(int adminId, String password) {
		super();
		this.adminId = adminId;
		this.adminPass = password;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return adminPass;
	}
	public void setPassword(String password) {
		this.adminPass = password;
	}
}
