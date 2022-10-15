package com.cg.flatRental.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
public class Flat {
	@Id
	@GeneratedValue
	private int flatId;
	private int flatNo;
	private String flatType;
	private int rentalCost;
	private boolean availability;
	private boolean isApproved;
	
	@ManyToOne
	@JoinColumn(name="landLordId")
	@JsonBackReference
	private LandLord flatLandLord;
	
	@Embedded
	private Address flatAddress;
	
	@Embedded
	private Amenities flatAmenities;
	public Flat() {}
	
	public Address getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(Address flatAddress) {
		this.flatAddress = flatAddress;
	}

	public Flat(int flatId, int flatNo, String flatType, int rentalCost, boolean availability, boolean isApproved,
			LandLord flatLandLord, Address flatAddress) {
		super();
		this.flatId = flatId;
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.rentalCost = rentalCost;
		this.availability = availability;
		this.isApproved = isApproved;
		this.flatLandLord = flatLandLord;
		this.flatAddress = flatAddress;
	}

	public LandLord getFlatLandLord() {
		return flatLandLord;
	}
	public void setFlatLandLord(LandLord flatLandLord) {
		this.flatLandLord = flatLandLord;
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
	public int getRentalCost() {
		return rentalCost;
	}
	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}
	
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
