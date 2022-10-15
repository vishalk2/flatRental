package com.cg.flatRental.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LandLord extends User{
	@Id
	@GeneratedValue
	private int landLordId;
	private String landLordName;
	private int landLordAge;
	@OneToMany(mappedBy="societyLandLord")
	@JsonManagedReference
	private List<Society> societyList;
	@OneToMany(mappedBy="flatLandLord")
	@JsonManagedReference
	private List<Flat> flatList;
	public LandLord() {}
	public LandLord(int landLordId, String landLordName, int landLordAge, List<Society> societyList,
			List<Flat> flatList, long landLordPhoneNumber, String landLordEmailId) {
		super();
		this.landLordId = landLordId;
		this.landLordName = landLordName;
		this.landLordAge = landLordAge;
		this.societyList = societyList;
		this.flatList = flatList;
		this.landLordPhoneNumber = landLordPhoneNumber;
		this.landLordEmailId = landLordEmailId;
	}
	public int getLandLordId() {
		return landLordId;
	}
	public void setLandLordId(int landLordId) {
		this.landLordId = landLordId;
	}
	public String getLandLordName() {
		return landLordName;
	}
	public void setLandLordName(String landLordName) {
		this.landLordName = landLordName;
	}
	public int getLandLordAge() {
		return landLordAge;
	}
	public void setLandLordAge(int landLordAge) {
		this.landLordAge = landLordAge;
	}
	public List<Society> getSocietyList() {
		return societyList;
	}
	public void setSocietyList(List<Society> societyList) {
		this.societyList = societyList;
	}
	public List<Flat> getFlatList() {
		return flatList;
	}
	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}
	public long getLandLordPhoneNumber() {
		return landLordPhoneNumber;
	}
	public void setLandLordPhoneNumber(long landLordPhoneNumber) {
		this.landLordPhoneNumber = landLordPhoneNumber;
	}
	public String getLandLordEmailId() {
		return landLordEmailId;
	}
	public void setLandLordEmailId(String landLordEmailId) {
		this.landLordEmailId = landLordEmailId;
	}
	private long landLordPhoneNumber;
	private String landLordEmailId;
	
}
