package com.cg.flatRental.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Amenities {
	
	private boolean garden;
	private boolean swimmingPool;
	private boolean carParking;
	private String houseFacing;
	private double squareFeet;
	
	public Amenities() {
	}
	
	public Amenities(boolean garden, boolean swimmingPool, boolean carParking, String houseFacing, double squareFeet) {
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

	@Override
	public String toString() {
		return "Amenities [garden=" + garden + ", swimmingPool=" + swimmingPool +
				", carParking=" + carParking + ", houseFacing=" + houseFacing +
				", squareFeet=" + squareFeet;
	}
}