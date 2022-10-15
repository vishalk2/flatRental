package com.cg.flatRental.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String area;
	private String city;
	private String state;
	private String country;
	private int pinCode;
	
	public Address() {
	}

	public Address(String area, String city, String state, String country, int pinCode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
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

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [area=" + area + ", city=" + city +
				", state=" + state + ", country=" + country +
				", pincode=" + pinCode + "]";
	}
}
