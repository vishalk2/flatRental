package com.cg.flatRental.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Amenities {
	private boolean garden;
	private boolean swimmingPool;
	private boolean carParking;
	private String houseFacing;
	public Amenities() {
		
	}
	public Amenities(boolean garden, boolean swimmmingPool, boolean carParking, String houseFacing) {
		super();
		this.garden = garden;
		this.swimmingPool = swimmmingPool;
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