package com.cg.flatRental.secure;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	@NotBlank(message = "User Name cannot be empty")
	private String userName;
	@NotBlank(message = "Password cannot be empty")
	private String password;
	
	//default constructor for JSON Parsing
	public JwtRequest()
	{
	}
	
	

	public JwtRequest(@NotBlank(message = "User Name cannot be empty") String userName,
			@NotBlank(message = "Password cannot be empty") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


/*
	public JwtRequest(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}
*/
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
