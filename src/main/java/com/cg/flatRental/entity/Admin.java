<<<<<<< HEAD
package com.cg.flatRental.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue
	private int adminId;
	private String adminUserName;
	private String adminPassword;
	public Admin() {}
	public Admin(int adminId, String adminUserName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
=======
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
>>>>>>> 95c6f12de5b5b14e711474f4ee795c5d0adc7545
