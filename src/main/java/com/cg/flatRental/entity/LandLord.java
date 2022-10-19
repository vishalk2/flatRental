package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="landlord_info")
public class LandLord extends User{
	
//	//@NotEmpty(message = "LandLord Name can't be empty!")
//	@Size(min = 3, max = 25, message = "Invalid LandLord name. Please enter a vaild LandLord name!")
//	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! Re-enter the name")
	private String landLordName;
	
//	//@NotEmpty(message = "LandLord Age can't be empty!")
//	@Size(min = 1, max = 120, message = "Invalid Age. Please enter a vaild age.")
//	@Pattern(regexp = "^[1-9]$|^[1-9][0-9]$|^(100)$", message = "Invalid input:Enter numbers only")
	private int landLordAge;
	
	@OneToMany(mappedBy = "societyLandlord")
	@JsonManagedReference("societylist")
	private List<Society> societyList;
	
	@OneToMany(mappedBy = "flatLandLord")
	@JsonManagedReference("flatlist")
	private List<Flat> flatList;
	
//	//@NotEmpty(message = "Phone Number can't be empty!")
//	@Size(min = 10, max = 10, message = "Invalid Phone Number. Please enter a vaild phone number of 10 digits")
//	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	private long landLordPhoneNumber;
	
//	//@NotEmpty(message = "Email ID can't be empty!")
//	@Size(min = 2, max = 30, message = "Invalid Email ID. Please enter a vaild email ID")
//	@Email(message = "Not a proper Email ID format! Enter again")
	private String landLordEmailId;
	
	@OneToMany
	private List<BookingRequest> bookingReqs;
	
	public LandLord() {
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

	public List<BookingRequest> getBookingReqs() {
		return bookingReqs;
	}

	public void setBookingReqs(List<BookingRequest> bookingReqs) {
		this.bookingReqs = bookingReqs;
	}
}