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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
	
	@Min(value = 1, message = "Flat number must be greater than 0!")
	@Max(value = 1000000000, message = "Flat number cannot be greater than 1000000000!")
	private int flatNo;
	
	@NotBlank(message = "Flat Type cannot be empty")
	private String flatType;
	
	@Min(value = 1, message = "Rental Cost must be greater than 0!")
	@Max(value = 1000000000, message = "Rental Cost cannot be greater than 1000000000!")
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

	public Flat(
			@Min(value = 1, message = "Flat number must be greater than 0!") @Max(value = 1000000000, message = "Flat number cannot be greater than 1000000000!") int flatNo,
			@NotBlank(message = "Flat Type cannot be empty") String flatType,
			@Min(value = 1, message = "Rental Cost must be greater than 0!") @Max(value = 1000000000, message = "Rental Cost cannot be greater than 1000000000!") double rentalCost,
			LandLord flatLandLord, Society flatSociety, boolean available, boolean approved, Address flatAddress,
			Amenities flatAmenities) {
		super();
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.rentalCost = rentalCost;
		this.flatLandLord = flatLandLord;
		this.flatSociety = flatSociety;
		this.available = available;
		this.approved = approved;
		this.flatAddress = flatAddress;
		this.flatAmenities = flatAmenities;
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
