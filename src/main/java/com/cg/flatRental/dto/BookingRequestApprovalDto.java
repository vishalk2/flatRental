package com.cg.flatRental.dto;

public class BookingRequestApprovalDto {
	
	private int reqId;
	private boolean approved;
	
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
