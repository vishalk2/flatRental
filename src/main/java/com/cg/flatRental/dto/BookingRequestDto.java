package com.cg.flatRental.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingRequestDto {
	
	private int flatId;
	
	private int tenantId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	public BookingRequestDto() {
	}

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
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
}
