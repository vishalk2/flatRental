package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.flatRental.secure.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="landlord_info")
public class LandLord extends User{
	
	@NotBlank(message = "Landlord Name cannot be empty")
	private String landLordName;
	
	@Min(value = 18, message = "Age must be greater than 18 years!")
	@Max(value = 120, message = "Age must not be greater than 120 years!")
	private int landLordAge;
	
	@OneToMany(mappedBy = "societyLandlord")
	@JsonManagedReference("societylist")
	private List<Society> societyList;
	
	@OneToMany(mappedBy = "flatLandLord")
	@JsonManagedReference("flatlist")
	private List<Flat> flatList;
	
	private long landLordPhoneNumber;
	
	@NotBlank(message = "EmailId cannot be empty")
	@Email(message = "Not the proper Email ID format! enter again")
	private String landLordEmailId;
	
	@OneToMany
	private List<BookingRequest> bookingReqs;
	
	public LandLord() {
	}

	public LandLord(@NotBlank(message = "Landlord Name cannot be empty") String landLordName,
			@Min(value = 18, message = "Age must be greater than 18 years!") @Max(value = 120, message = "Age must not be greater than 120 years!") int landLordAge,
			List<Society> societyList, List<Flat> flatList, long landLordPhoneNumber,
			@NotBlank(message = "EmailId cannot be empty") @Email(message = "Not the proper Email ID format! enter again") String landLordEmailId,
			List<BookingRequest> bookingReqs) {
		super();
		this.landLordName = landLordName;
		this.landLordAge = landLordAge;
		this.societyList = societyList;
		this.flatList = flatList;
		this.landLordPhoneNumber = landLordPhoneNumber;
		this.landLordEmailId = landLordEmailId;
		this.bookingReqs = bookingReqs;
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
