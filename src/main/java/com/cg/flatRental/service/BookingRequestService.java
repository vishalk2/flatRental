package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flatRental.dto.BookingRequestDto;
import com.cg.flatRental.entity.BookingRequest;
import com.cg.flatRental.entity.Flat;
import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.BookingRequestNotFoundException;
import com.cg.flatRental.exceptions.FlatAvailabilityException;
import com.cg.flatRental.exceptions.FlatNotFoundException;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.IBookingRequestService;
import com.cg.flatRental.repository.IBookingRequestRepository;
import com.cg.flatRental.repository.IFlatRepository;
import com.cg.flatRental.repository.ITenantRepository;

@Service
public class BookingRequestService implements IBookingRequestService {
	
	@Autowired
	private IBookingRequestRepository bookingrequestRepository;
	
	@Autowired
	private IFlatRepository flatRepository;
	
	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public BookingRequest addBookingRequestService(BookingRequestDto bookingReqDto) throws FlatNotFoundException, FlatAvailabilityException, BookingRequestNotFoundException {
		int flatId = bookingReqDto.getFlatId();
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if(optionalFlat.isPresent()) {
			Flat flat = optionalFlat.get();
			if(flat.isAvailable()) {
				BookingRequest bookingReq = converterToDtoFromEntity(bookingReqDto);
				BookingRequest newBookingReq = bookingrequestRepository.save(bookingReq);
				return newBookingReq;
			}
			else {
				throw new FlatAvailabilityException("Flat not available");
			}
		}
		else {
			throw new FlatNotFoundException("Flat details not found!");
		}
		
	}

	@Override
	public BookingRequest deleteBookingRequestService(int reqId) throws BookingRequestNotFoundException {
		Optional<BookingRequest> optionalBookingReq = bookingrequestRepository.findById(reqId);
		if(optionalBookingReq.isPresent()) {
			BookingRequest bookingRequest = optionalBookingReq.get();
			bookingrequestRepository.deleteById(reqId);
			return bookingRequest;
		}
		else {
			 throw new BookingRequestNotFoundException("Booking details not found!");
		}
	}

	@Override
	public BookingRequest updateBookingRequestService(int reqId, BookingRequest bookingreq) throws BookingRequestNotFoundException {
		Optional<BookingRequest> optionalBookingReq = bookingrequestRepository.findById(reqId);
		if(optionalBookingReq.isPresent()) {
			BookingRequest bookingRequest = optionalBookingReq.get();
			bookingrequestRepository.save(bookingreq);
			return bookingRequest;
		}
		else {
			 throw new BookingRequestNotFoundException("Booking details not found!");
		}
	}

	@Override
	public BookingRequest viewBookingRequestService(int reqId) throws BookingRequestNotFoundException {
		Optional<BookingRequest> optionalBookingReq = bookingrequestRepository.findById(reqId);
		if(optionalBookingReq.isPresent()) {
			BookingRequest bookingRequest = optionalBookingReq.get();
			return bookingRequest;
		}
		else {
			 throw new BookingRequestNotFoundException("Booking details not found!");
		}
	}

	@Override
	public List<BookingRequest> viewAllBookingRequestService() {
		List<BookingRequest> bookingRequestList = new ArrayList<>();
		Iterable<BookingRequest> bookingRequests = bookingrequestRepository.findAll();
		bookingRequests.forEach(br->bookingRequestList.add(br));
		return bookingRequestList;
	}
	
	public BookingRequest converterToDtoFromEntity(BookingRequestDto bookingReqDto) throws BookingRequestNotFoundException {
		int flatId = bookingReqDto.getFlatId();
		long tenantId = bookingReqDto.getTenantId();
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalFlat.isPresent() && optionalTenant.isPresent()) {
			Flat flat = optionalFlat.get();
			Tenant tenant = optionalTenant.get();
			
			BookingRequest bookingReq = new BookingRequest();
			bookingReq.setApproved(false); // approval from landlord
			bookingReq.setFlat(flat);
			bookingReq.setTenant(tenant);
			bookingReq.setBookingFromDate(bookingReqDto.getBookingFromDate());
			bookingReq.setBookingToDate(bookingReqDto.getBookingToDate());
			
			return bookingReq;
		}
		else {
			 throw new BookingRequestNotFoundException("Booking details not found!");
		}
	}

	@Override
	@Transactional
	public BookingRequest updateBookingRequestApproval(int reqId, boolean approval) throws BookingRequestNotFoundException, FlatAvailabilityException {
		int br = bookingrequestRepository.updateBookingRequestApproval(reqId,approval);
		if(br>0) {
			int flatId = bookingrequestRepository.getFlatIdByBookingRequestId(reqId);
			int check = flatRepository.updateFlatAvailability(flatId, !approval);
			if(check>0) {
				return viewBookingRequestService(reqId);
			}
			else {
				 throw new FlatAvailabilityException("Flat availability could not be updated");
			}
		}
		else {
			 throw new BookingRequestNotFoundException("Booking request not found!");
		}
	}

	@Override
	public List<BookingRequest> getAllApprovedBookingRequestsService() {
		List<BookingRequest> bookingRequestList = new ArrayList<>();
		Iterable<BookingRequest> bookingRequests = bookingrequestRepository.getAllApprovedBookingRequests();
		bookingRequests.forEach(br->bookingRequestList.add(br));
		return bookingRequestList;
	}

	@Override
	public List<BookingRequest> getAllBookingRequestByLandLordUserName(String userName) throws UserNotFoundException {
		List<BookingRequest> bookingRequestList = new ArrayList<>();
		Iterable<BookingRequest> bookingRequests = bookingrequestRepository.getAllBookingRequestsByLandLordUserName(userName);
		bookingRequests.forEach(br->bookingRequestList.add(br));
		return bookingRequestList;
	}

	@Override
	public List<BookingRequest> getAllBookingRequestByTenantUserName(String userName) throws UserNotFoundException{
		List<BookingRequest> bookingRequestList = new ArrayList<>();
		Iterable<BookingRequest> bookingRequests = bookingrequestRepository.getAllBookingRequestsByTenantUserName(userName);
		bookingRequests.forEach(br->bookingRequestList.add(br));
		return bookingRequestList;
	}
}
