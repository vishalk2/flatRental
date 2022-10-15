package com.cg.flatRental.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FlatBooking {
	@Id
	@GeneratedValue
	private int bookingNo;
	@OneToOne
	@JoinColumn(name ="flatId")
	private Flat flat;
	@OneToOne
	@JoinColumn(name ="tenantId")
	private Tenant tenant;
	private Date bookingFromDate;
	private Date bookingToDate;
	private int noOfPeople;
	public FlatBooking() {
	}
	
	public FlatBooking(int bookingNo, Flat flat, Tenant tenant, Date bookingFromDate, Date bookingToDate,
			int noOfPeople) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenant = tenant;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
		this.noOfPeople = noOfPeople;
	}



	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Date getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(Date bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	public Date getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(Date bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	
}