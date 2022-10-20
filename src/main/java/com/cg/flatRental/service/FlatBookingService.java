package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatRental.dto.FlatBookingDto;
import com.cg.flatRental.entity.BookingRequest;
import com.cg.flatRental.entity.Flat;
import com.cg.flatRental.entity.FlatBooking;
import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.FlatBookingException;
import com.cg.flatRental.iservice.IFlatBookingService;
import com.cg.flatRental.repository.IBookingRequestRepository;
import com.cg.flatRental.repository.IFlatBookingRepository;
import com.cg.flatRental.repository.IFlatRepository;
import com.cg.flatRental.repository.ITenantRepository;

@Service
public class FlatBookingService implements IFlatBookingService {
	
	@Autowired
	private IFlatBookingRepository flatbookingRepository;
	
	@Autowired
	private IBookingRequestRepository bookingrequestRepository;
	
	@Autowired
	private IFlatRepository flatRepository;
	
	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public FlatBooking addFlatBookingService(FlatBookingDto flatBookingDto) throws FlatBookingException {
		FlatBooking flatBooking = dtoEntityConverter(flatBookingDto);
		FlatBooking newFlatBooking = flatbookingRepository.save(flatBooking);
		return newFlatBooking;
	}

	@Override
	public FlatBooking deleteFlatBookingService(int bookingId) throws FlatBookingException {
		Optional<FlatBooking> optionalFlatBooking = flatbookingRepository.findById(bookingId);
		if(optionalFlatBooking.isPresent()) {
			FlatBooking flatBooking = optionalFlatBooking.get();
			flatbookingRepository.deleteById(bookingId);
			return flatBooking;
		}
		else {
			 throw new FlatBookingException("Flat Booking details not found!");
		}
	}

	@Override
	public FlatBooking updateFlatBookingService(int bookingId, FlatBooking flatBooking) throws FlatBookingException {
		Optional<FlatBooking> optionalFlatBooking = flatbookingRepository.findById(bookingId);
		if(optionalFlatBooking.isPresent()) {
			FlatBooking updatedFlatBooking = optionalFlatBooking.get();
			flatbookingRepository.save(flatBooking);
			return updatedFlatBooking;
		}
		else {
			 throw new FlatBookingException("Flat Booking details not found!");
		}
	}

	@Override
	public FlatBooking viewFlatBookingService(int bookingId) throws FlatBookingException {
		Optional<FlatBooking> optionalFlatBooking = flatbookingRepository.findById(bookingId);
		if(optionalFlatBooking.isPresent()) {
			FlatBooking flatBooking = optionalFlatBooking.get();
			return flatBooking;
		}
		else {
			 throw new FlatBookingException("Flat Booking details not found!");
		}
	}

	@Override
	public List<FlatBooking> viewAllFlatBookingService() {
		List<FlatBooking> flatbookingList = new ArrayList<>();
		Iterable<FlatBooking> flatBookings = flatbookingRepository.findAll();
		flatBookings.forEach(fb->flatbookingList.add(fb));
		return flatbookingList;
	}
	
	public FlatBooking dtoEntityConverter(FlatBookingDto flatBookingDto) throws FlatBookingException {
		int reqId = flatBookingDto.getReqId();
		long tenantId = flatBookingDto.getTenantId();
		int flatId = bookingrequestRepository.getFlatIdByBookingRequestId(reqId);
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		Optional<BookingRequest> optionalBookingRequest = bookingrequestRepository.findById(reqId);
		if(optionalFlat.isPresent() && optionalTenant.isPresent() && optionalBookingRequest.isPresent()) {
			Flat flat = optionalFlat.get();
			Tenant tenant = optionalTenant.get();
			BookingRequest bookingRequest = optionalBookingRequest.get();
			
			FlatBooking flatBooking = new FlatBooking();
			flatBooking.setBookingFromDate(bookingRequest.getBookingFromDate());
			flatBooking.setBookingToDate(bookingRequest.getBookingToDate());
			flatBooking.setFlat(flat);
			flatBooking.setTenant(tenant);
			flatBooking.setBookingReq(bookingRequest);
			
			return flatBooking;
		}
		else {
			 throw new FlatBookingException("Booking request details could not be found!");
		}
	}
}
