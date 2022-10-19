package com.cg.flatRental.dto;

public class LandLordPhoneNumberUpdateDto {
	
	private int userId;
	private long landLordPhoneNumber;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getLandLordPhoneNumber() {
		return landLordPhoneNumber;
	}
	public void setLandLordPhoneNumber(long landLordPhoneNumber) {
		this.landLordPhoneNumber = landLordPhoneNumber;
	}
}
