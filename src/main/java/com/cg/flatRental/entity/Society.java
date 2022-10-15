package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Society {
	@Id
	@GeneratedValue
	private int societyId;
	private String societyName;
	private boolean isApproved;
	@OneToMany
	@JoinColumn(name="flatId")
	private List<Flat> flatList;
	@ManyToOne
	@JoinColumn(name ="landLordId")
	@JsonBackReference
	private LandLord societyLandLord;
	@Embedded
	private Address societyAddress;
	public Society(){}
	
	public Society(int societyId, String societyName, boolean isApproved, List<Flat> flatList, LandLord societyLandLord,
			Address societyAddress) {
		super();
		this.societyId = societyId;
		this.societyName = societyName;
		this.isApproved = isApproved;
		this.flatList = flatList;
		this.societyLandLord = societyLandLord;
		this.societyAddress = societyAddress;
	}

	public Address getSocietyAddress() {
		return societyAddress;
	}

	public void setSocietyAddress(Address societyAddress) {
		this.societyAddress = societyAddress;
	}

	public int getSocietyId() {
		return societyId;
	}
	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}
	public LandLord getSocietyLandLord() {
		return societyLandLord;
	}
	public void setSocietyLandLord(LandLord societyLandLord) {
		this.societyLandLord = societyLandLord;
	}
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	public List<Flat> getFlatList() {
		return flatList;
	}
	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
}
