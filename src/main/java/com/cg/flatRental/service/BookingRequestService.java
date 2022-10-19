package com.cg.flatRental.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flatRental.dto.BookingRequestDto;
import com.cg.flatRental.entity.BookingRequest;
import com.cg.flatRental.entity.Flat;
import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.BookingRequestNotFoundException;
import com.cg.flatRental.repository.IBookingRequestRepository;
import com.cg.flatRental.repository.IFlatRepository;
import com.cg.flatRental.repository.ITenantRepository;

@Component
public class BookingRequestService implements IBookingRequestService {
	
	@Autowired
	private IBookingRequestRepository bookingrequestRepository;
	
	@Autowired
	private IFlatRepository flatRepository;
	
	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public BookingRequest addBookingRequestService(BookingRequestDto bookingReqDto) {
		BookingRequest bookingReq = converterToDtoFromEntity(bookingReqDto);
		BookingRequest newBookingReq = bookingrequestRepository.save(bookingReq);
		return newBookingReq;
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
	
	public BookingRequest converterToDtoFromEntity(BookingRequestDto bookingReqDto) {
		int flatId = bookingReqDto.getFlatId();
		int tenantId = bookingReqDto.getTenantId();
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
		return null;
	}

	@Override
	@Transactional
	public BookingRequest updateBookingRequestApproval(int reqId, boolean approval) throws BookingRequestNotFoundException {
		int br = bookingrequestRepository.updateBookingRequestApproval(reqId,approval);
		if(br>0) {
			return viewBookingRequestService(reqId);
		}
		else {
			throw new BookingRequestNotFoundException("Booking request details not found!");
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
	public List<BookingRequest> getAllBookingRequestByLandLordUserName(String userName) {
		List<BookingRequest> bookingRequestList = new ArrayList<>();
		Iterable<BookingRequest> bookingRequests = bookingrequestRepository.getAllBookingRequestsByLandLordUserName(userName);
		bookingRequests.forEach(br->bookingRequestList.add(br));
		return bookingRequestList;
	}
}
