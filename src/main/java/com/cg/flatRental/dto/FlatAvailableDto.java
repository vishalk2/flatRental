package com.cg.flatRental.dto;

public class FlatAvailableDto {
	
	private int flatId;
	private boolean available;
	
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
