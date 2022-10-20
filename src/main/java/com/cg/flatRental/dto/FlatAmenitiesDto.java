package com.cg.flatRental.dto;

public class FlatAmenitiesDto {
	private int flatId;
	private boolean garden;
	private boolean swimmingPool;
	private boolean carParking;
	private String houseFacing;
	private double squareFeet;
	
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public boolean isCarParking() {
		return carParking;
	}
	public void setCarParking(boolean carParking) {
		this.carParking = carParking;
	}
	public String getHouseFacing() {
		return houseFacing;
	}
	public void setHouseFacing(String houseFacing) {
		this.houseFacing = houseFacing;
	}
	public double getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(double squareFeet) {
		this.squareFeet = squareFeet;
	}
}
