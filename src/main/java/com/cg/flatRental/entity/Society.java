package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Society {
	@Id
	private int societyId;
	private String societyName;
	private String city;
	private String state;
	private int pin;
	private boolean isApproved;
	@OneToMany(mappedBy="society")
	@JsonManagedReference
	private List<Flat> flatList;
	@ManyToOne
	@JoinColumn(name ="landLordId")
	@JsonBackReference
	LandLord societyLandLord;
	Society(){}
	public Society(int societyId, String societyName, String city, String state, int pin, boolean isApproved,
			List<Flat> flatList, LandLord societyLandLord) {
		super();
		this.societyId = societyId;
		this.societyName = societyName;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.isApproved = isApproved;
		this.flatList=flatList;
		this.societyLandLord = societyLandLord;
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
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
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
