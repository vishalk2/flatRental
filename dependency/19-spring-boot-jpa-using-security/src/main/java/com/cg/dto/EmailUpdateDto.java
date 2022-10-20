package com.cg.dto;

public class EmailUpdateDto {

	private int cid;
	private String newEmail="hello";
	public int getCid() {
		return cid;
	} 
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
		System.out.println(newEmail);
		System.out.println("*****************************");
	}
	public String getNewEmail() {
		return newEmail;
	}
	public EmailUpdateDto() {
		
	}
	public EmailUpdateDto(int cid, String newEmail) {
		super();
		this.cid = cid;
		this.newEmail = newEmail;
	}
	
}
