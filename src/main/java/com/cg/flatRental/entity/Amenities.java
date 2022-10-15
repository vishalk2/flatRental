package com.cg.flatRental.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Amenities {
	private boolean garden;
	private boolean swimmingPool;
	private boolean carParking;
	private String houseFacing;
	private float squareFeet;
	
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public float getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(float squareFeet) {
		this.squareFeet = squareFeet;
	}
	public Amenities() {
		
	}

	public Amenities(boolean garden, boolean swimmingPool, boolean carParking, String houseFacing, float squareFeet) {
		super();
		this.garden = garden;
		this.swimmingPool = swimmingPool;
		this.carParking = carParking;
		this.houseFacing = houseFacing;
		this.squareFeet = squareFeet;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	public boolean isSwimmmingPool() {
		return swimmingPool;
	}
	public void setSwimmmingPool(boolean swimmmingPool) {
		this.swimmingPool = swimmmingPool;
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
	

}
