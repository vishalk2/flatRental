package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.flatRental.entity.FlatBooking;
import com.cg.flatRental.exceptions.FlatBookingNotFoundException;
import com.cg.flatRental.repository.IFlatBookingRepository;

@Component
public class FlatBookingService implements IFlatBookingService {
	
	@Autowired
	private IFlatBookingRepository flatbookingRepository;

	@Override
	public FlatBooking addFlatBookingService(FlatBooking flatBooking) {
		FlatBooking newFlatBooking = flatbookingRepository.save(flatBooking);
		return newFlatBooking;
	}

	@Override
	public FlatBooking deleteFlatBookingService(int bookingId) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = flatbookingRepository.findById(bookingId);
		if(optionalFlatBooking.isPresent()) {
			FlatBooking flatBooking = optionalFlatBooking.get();
			flatbookingRepository.deleteById(bookingId);
			return flatBooking;
		}
		else {
			throw new FlatBookingNotFoundException("Flat Booking details not found!");
		}
	}

	@Override
	public FlatBooking updateFlatBookingService(int bookingId, FlatBooking flatBooking) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = flatbookingRepository.findById(bookingId);
		if(optionalFlatBooking.isPresent()) {
			FlatBooking updatedFlatBooking = optionalFlatBooking.get();
			flatbookingRepository.save(flatBooking);
			return updatedFlatBooking;
		}
		else {
			throw new FlatBookingNotFoundException("Flat Booking details not found!");
		}
	}

	@Override
	public FlatBooking viewFlatBookingService(int bookingId) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = flatbookingRepository.findById(bookingId);
		if(optionalFlatBooking.isPresent()) {
			FlatBooking flatBooking = optionalFlatBooking.get();
			return flatBooking;
		}
		else {
			throw new FlatBookingNotFoundException("Flat Booking details not found!");
		}
	}

	@Override
	public List<FlatBooking> viewAllFlatBookingService() {
		List<FlatBooking> flatbookingList = new ArrayList<>();
		Iterable<FlatBooking> flatBookings = flatbookingRepository.findAll();
		flatBookings.forEach(fb->flatbookingList.add(fb));
		return flatbookingList;
	}
}

