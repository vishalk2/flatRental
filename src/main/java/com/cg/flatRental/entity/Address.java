package com.cg.flatRental.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {
	@NotBlank(message = "Area cannot be empty")
	private String area;
	@NotBlank(message = "City cannot be empty")
	private String city;
	@NotBlank(message = "State cannot be empty")
	private String state;
	@NotBlank(message = "Country cannot be empty")
	private String country;

	private int pincode;
	
	public Address() {
	}

	public Address(@NotBlank(message = "Area cannot be empty") String area,
			@NotBlank(message = "City cannot be empty") String city,
			@NotBlank(message = "State cannot be empty") String state,
			@NotBlank(message = "Country cannot be empty") String country,
			int pincode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
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
		return pincode;
	}

	public void setPinCode(int pinCode) {
		this.pincode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [area=" + area + ", city=" + city +
				", state=" + state + ", country=" + country +
				", pincode=" + pincode + "]";
	}
}
