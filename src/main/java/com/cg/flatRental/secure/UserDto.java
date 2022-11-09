package com.cg.flatRental.secure;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {
	@NotBlank(message = "User Name cannot be empty")
	@Column(unique = true)
	private String userName;
	@NotBlank(message = "Password cannot be empty")
    private String password;
	@NotBlank(message = "User Type cannot be empty")
    private String userType;
	@NotBlank(message = "Name cannot be empty")
    private String name;
    private long userPhoneNumber;
    @Min(value = 18, message = "Age must be greater than 18 years!")
	@Max(value = 120, message = "Age must not be greater than 120 years!")
    private int userAge;
    @NotBlank(message = "EmailId cannot be empty")
	@Email(message = "Not a valid Email ID! Enter again!")
    private String emailId;
    
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
		this.userType = userType.toLowerCase();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
