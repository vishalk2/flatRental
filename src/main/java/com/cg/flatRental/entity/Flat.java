package com.cg.flatRental.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
@Table(name="flat_info")
public class Flat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flatId;
	
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
	
	@ManyToOne
	@JoinColumn(name="landlordId")
	@JsonBackReference("flatlist")
	private LandLord flatLandLord;
	
	@ManyToOne
	@JoinColumn(name="societyId")
	@JsonBackReference("societyflats")
	private Society flatSociety;
	
	private boolean available;
	
	private boolean approved;
	
	@Embedded
	private Address flatAddress;
	
	@Embedded
	private Amenities flatAmenities;
	
	public Flat() {
	}


	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
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

	public LandLord getFlatLandLord() {
		return flatLandLord;
	}

	public void setFlatLandLord(LandLord flatLandLord) {
		this.flatLandLord = flatLandLord;
	}

	public Society getFlatSociety() {
		return flatSociety;
	}

	public void setFlatSociety(Society flatSociety) {
		this.flatSociety = flatSociety;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Address getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(Address flatAddress) {
		this.flatAddress = flatAddress;
	}

	public Amenities getFlatAmenities() {
		return flatAmenities;
	}

	public void setFlatAmenities(Amenities flatAmenities) {
		this.flatAmenities = flatAmenities;
	}
}