package com.cg.flatRental.dto;

public class SocietyApprovalDto {
	
	private int societyId;
	private boolean approved;
	
	public int getSocietyId() {
		return societyId;
	}
	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
