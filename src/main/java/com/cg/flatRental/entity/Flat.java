package com.cg.flatRental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity

public class Flat {
	@Id
	private int flatId;
	private int flatNo;
	private String flatType;
	@ManyToOne
	@JoinColumn(name="landLordId")
	@JsonBackReference
	private LandLord flatLandLord;
	@ManyToOne
	@JoinColumn(name ="societyId")
	@JsonBackReference
	private Society society;
	public Flat() {}
	public Flat(int flatId, int flatNo, String flatType, int rentalCost, String flatOwnername, boolean availability,
			boolean isApproved) {
		super();
		this.flatId = flatId;
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.rentalCost = rentalCost;
		this.flatOwnername = flatOwnername;
		this.availability = availability;
		this.isApproved = isApproved;
	}
	public LandLord getFlatLandLord() {
		return flatLandLord;
	}
	public void setFlatLandLord(LandLord flatLandLord) {
		this.flatLandLord = flatLandLord;
	}
	public Society getSociety() {
		return society;
	}
	public void setSociety(Society society) {
		this.society = society;
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
	public String getFlatOwnername() {
		return flatOwnername;
	}
	public void setFlatOwnername(String flatOwnername) {
		this.flatOwnername = flatOwnername;
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
	private int rentalCost;
	private String flatOwnername;
	private boolean availability;
	private boolean isApproved;
}
