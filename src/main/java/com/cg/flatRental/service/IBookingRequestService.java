package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.dto.BookingRequestDto;
import com.cg.flatRental.entity.BookingRequest;
import com.cg.flatRental.exceptions.BookingRequestNotFoundException;

public interface IBookingRequestService {
	public BookingRequest addBookingRequestService(BookingRequestDto bookingReqDto);
	public BookingRequest deleteBookingRequestService(int reqId) throws BookingRequestNotFoundException;
	public BookingRequest updateBookingRequestService(int reqId, BookingRequest bookingReq) throws BookingRequestNotFoundException;
	public BookingRequest viewBookingRequestService(int reqId) throws BookingRequestNotFoundException;
	public List<BookingRequest> viewAllBookingRequestService();
	public BookingRequest updateBookingRequestApproval(int reqId, boolean approval) throws BookingRequestNotFoundException ;
	public List<BookingRequest> getAllApprovedBookingRequestsService();
	public List<BookingRequest> getAllBookingRequestByLandLordUserName(String userName);
}
