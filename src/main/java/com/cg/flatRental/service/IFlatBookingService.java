package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.entity.FlatBooking;
import com.cg.flatRental.exceptions.FlatBookingNotFoundException;

public interface IFlatBookingService {
	public FlatBooking addFlatBookingService(FlatBooking flatBooking);
	public FlatBooking deleteFlatBookingService(int bookingId) throws FlatBookingNotFoundException;
	public FlatBooking updateFlatBookingService(int bookingId, FlatBooking flatBooking) throws FlatBookingNotFoundException;
	public FlatBooking viewFlatBookingService(int bookingId) throws FlatBookingNotFoundException;
	public List<FlatBooking> viewAllFlatBookingService();
}
