package com.cg.flatRental.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FlatDto {
	
	private int landlordId;
	
//	@NotEmpty(message = "Flat Number can't be empty!")
//	@Size(min = 1, max=999, message = "Invalid number. Please enter a vaild flat number.")
//	@Pattern(regexp = "^[0-9][0-9]{0,2}$", message = "Invalid input:Enter numbers only")
	private int flatNo;
	
//	@NotEmpty(message = "Flat type can't be empty!")
//	@Size(min = 3, max = 25, message = "Invalid Entry. Please enter a vaild Flat type!")
//	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! Re-enter the name")
	private String flatType;
	
//	@NotEmpty(message = "Rental Cost can't be empty!")
//	@DecimalMin(value = "0", message = "Rental Cost should not be zero")
	private double rentalCost;
	
	private int societyId;
	
	private String area;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	private boolean garden;
	private boolean swimmingPool;
	private boolean carParking;
	private String houseFacing;
	private double squareFeet;
	
	public int getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public double getRentalCost() {
		return rentalCost;
	}
	public void setRentalCost(double rentalCost) {
		this.rentalCost = rentalCost;
	}
	public int getSocietyId() {
		return societyId;
	}
	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
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
