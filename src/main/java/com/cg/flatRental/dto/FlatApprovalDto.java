package com.cg.flatRental.dto;

public class FlatApprovalDto {
	
	private int flatId;
	private boolean approved;
	
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
