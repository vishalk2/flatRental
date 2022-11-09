package com.cg.flatRental.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="booking_requests")
public class BookingRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reqId;
	
	@OneToOne
	@JoinColumn(name="flatId")
	private Flat flat;
	
	@ManyToOne
	@JoinColumn(name="tenantId")
	@JsonBackReference("tenantBookingRequests")
	private Tenant tenant;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	private boolean approved;
	
	
	public BookingRequest() {
	}

	public BookingRequest(Flat flat, Tenant tenant, LocalDate bookingFromDate, LocalDate bookingToDate,
			boolean approved) {
		super();
		this.flat = flat;
		this.tenant = tenant;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
		this.approved = approved;
	}

	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
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
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
