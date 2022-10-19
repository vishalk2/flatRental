package com.cg.flatRental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_info")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotEmpty(message = "Username can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Username. Please enter a vaild Username of minimum 3 characters!")
	@Column(unique = true)
	private String userName;
	
	@NotEmpty(message = "Password can't be empty!")
	@Size(min = 6, max = 40, message = "Password has to be of minimum 6 characters!")
	@Column
	private String password;
	
	@NotEmpty(message = "Usertype can't be empty!")
	@Column
	private String userType;
	
	public User(){
	}

	public User(String userName, String password, String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}