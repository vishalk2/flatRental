package com.cg.flatRental.iservice;

import java.util.List;

import com.cg.flatRental.dto.FlatBookingDto;
import com.cg.flatRental.entity.FlatBooking;
import com.cg.flatRental.exceptions.FlatBookingException;

public interface IFlatBookingService {
	public FlatBooking addFlatBookingService(FlatBookingDto flatBookingDto) throws FlatBookingException;
	public FlatBooking deleteFlatBookingService(int bookingId) throws FlatBookingException;
	public FlatBooking updateFlatBookingService(int bookingId, FlatBooking flatBooking) throws FlatBookingException;
	public FlatBooking viewFlatBookingService(int bookingId) throws FlatBookingException;
	public List<FlatBooking> viewAllFlatBookingService();
}

