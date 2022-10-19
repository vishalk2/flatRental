package com.cg.flatRental.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FlatBooking {
	
	@Id
	@GeneratedValue
	private int bookingNo;
	
	@OneToOne
	@JoinColumn(name ="flatId")
	private Flat flat;
	
	@OneToOne
	@JoinColumn(name ="userId")
	private Tenant tenant;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	@OneToOne
	@JoinColumn(name="reqId")
	private BookingRequest bookingReq;
	
	public FlatBooking() {
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

	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	public LocalDate getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	public BookingRequest getBookingReq() {
		return bookingReq;
	}

	public void setBookingReq(BookingRequest bookingReq) {
		this.bookingReq = bookingReq;
	}
}