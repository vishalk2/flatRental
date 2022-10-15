package com.cg.flatRental.entity;

public class Amenities {
	private boolean garden;
	private boolean swimmmingPool;
	private boolean carParking;
	private String houseFacing;
	public Amenities() {
		
	}
	public Amenities(boolean garden, boolean swimmmingPool, boolean carParking, String houseFacing) {
		super();
		this.garden = garden;
		this.swimmmingPool = swimmmingPool;
		this.carParking = carParking;
		this.houseFacing = houseFacing;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	public boolean isSwimmmingPool() {
		return swimmmingPool;
	}
	public void setSwimmmingPool(boolean swimmmingPool) {
		this.swimmmingPool = swimmmingPool;
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
