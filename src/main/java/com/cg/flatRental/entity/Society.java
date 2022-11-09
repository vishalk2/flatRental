package com.cg.flatRental.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="society_info")
public class Society {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int societyId;
	
	@NotBlank(message = "Society Name cannot be empty")
	private String societyName;
	
	@ManyToOne
	@JoinColumn(name="landlordId")
	@JsonBackReference("societylist")
	private LandLord societyLandlord;

	private boolean approved;
	
	@OneToMany
	@JsonManagedReference("societyflats")
	@JoinColumn(name="societyId")
	private List<Flat> flatList;
	
	@Embedded
	private Address societyAddress;
	
	public Society(){
	}


	public Society(@NotBlank(message = "Society Name cannot be empty") String societyName, LandLord societyLandlord,
			boolean approved, List<Flat> flatList, Address societyAddress) {
		super();
		this.societyName = societyName;
		this.societyLandlord = societyLandlord;
		this.approved = approved;
		this.flatList = flatList;
		this.societyAddress = societyAddress;
	}

	public int getSocietyId() {
		return societyId;
	}

	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public LandLord getSocietyLandlord() {
		return societyLandlord;
	}

	public void setSocietyLandlord(LandLord societyLandlord) {
		this.societyLandlord = societyLandlord;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public List<Flat> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}

	public Address getSocietyAddress() {
		return societyAddress;
	}

	public void setSocietyAddress(Address societyAddress) {
		this.societyAddress = societyAddress;
	}
}
