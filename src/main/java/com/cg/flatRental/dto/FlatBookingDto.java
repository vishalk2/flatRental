package com.cg.flatRental.dto;

import java.time.LocalDate;

public class FlatBookingDto {
	private long tenantId;
	private int reqId;
	
	public long getTenantId() {
		return tenantId;
	}
	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
}
