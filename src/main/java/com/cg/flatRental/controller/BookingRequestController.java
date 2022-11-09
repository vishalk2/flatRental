package com.cg.flatRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.dto.BookingRequestApprovalDto;
import com.cg.flatRental.dto.BookingRequestDto;
import com.cg.flatRental.entity.BookingRequest;
import com.cg.flatRental.exceptions.BookingRequestNotFoundException;
import com.cg.flatRental.exceptions.FlatAvailabilityException;
import com.cg.flatRental.exceptions.FlatNotFoundException;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.IBookingRequestService;

@Validated
@RestController
@RequestMapping("/bookingrequest")
public class BookingRequestController {
	
	@Autowired
	private IBookingRequestService bookingrequestService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<BookingRequest> addBookingRequest(@RequestBody @Valid BookingRequestDto bookingReqDto) throws FlatNotFoundException, FlatAvailabilityException, BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.addBookingRequestService(bookingReqDto),HttpStatus.OK);
	}
	
	@PutMapping(value="/{reqId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<BookingRequest> updateBookingRequest(@PathVariable int reqId, @Valid BookingRequest bookingReq) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.updateBookingRequestService(reqId, bookingReq),HttpStatus.OK);
	}
	
	@GetMapping(value="/{reqId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant') or hasAuthority('landlord')")
	public ResponseEntity<BookingRequest> getBookingRequest(@PathVariable int reqId) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.viewBookingRequestService(reqId),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{reqId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant') or hasAuthority('landlord')")
	public ResponseEntity<BookingRequest> removeBookingRequest(@PathVariable int reqId) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.deleteBookingRequestService(reqId),HttpStatus.OK);
	}
	
	@GetMapping(value="/all",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<List<BookingRequest>> getAllBookingRequests(){
		return new ResponseEntity<>(bookingrequestService.viewAllBookingRequestService(),HttpStatus.OK);
	}
	
	@GetMapping(value="/approved",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<List<BookingRequest>> getAllApprovedBookingRequests(){
		return new ResponseEntity<>(bookingrequestService.getAllApprovedBookingRequestsService(),HttpStatus.OK);
	}
	
	@PutMapping(value="/requests/{userName}/approval",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('landlord')")
	public ResponseEntity<BookingRequest> updateBookingRequestApproval(@RequestBody BookingRequestApprovalDto bookingReqApprovalDto) throws BookingRequestNotFoundException, FlatAvailabilityException{
		return new ResponseEntity<>(bookingrequestService.updateBookingRequestApproval(bookingReqApprovalDto.getReqId(), bookingReqApprovalDto.isApproved()),HttpStatus.OK);
	}
	
	@GetMapping(value="/requests/landlord/{userName}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('landlord')")
	public ResponseEntity<List<BookingRequest>> getAllBookingRequestsByLandlordUsername(@PathVariable String userName) throws UserNotFoundException{
		return new ResponseEntity<>(bookingrequestService.getAllBookingRequestByLandLordUserName(userName),HttpStatus.OK);
	}
	
	@GetMapping(value="/requests/tenant/{userName}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<List<BookingRequest>> getAllBookingRequestsByTenantUsername(@PathVariable String userName) throws UserNotFoundException{
		return new ResponseEntity<>(bookingrequestService.getAllBookingRequestByTenantUserName(userName),HttpStatus.OK);
	}
}
