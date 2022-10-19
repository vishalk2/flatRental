package com.cg.flatRental.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cg.flatRental.service.IBookingRequestService;

@RestController
@RequestMapping("/bookingrequest")
public class BookingRequestController {
	
	@Autowired
	private IBookingRequestService bookingrequestService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// accessible only to tenant
	public ResponseEntity<BookingRequest> addBookingRequest(@RequestBody BookingRequestDto bookingReqDto){
		return new ResponseEntity<>(bookingrequestService.addBookingRequestService(bookingReqDto),HttpStatus.OK);
	}
	
	@PutMapping(value="/{reqId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// accessible only to tenant
	public ResponseEntity<BookingRequest> updateBookingRequest(@PathVariable int reqId, BookingRequest bookingReq) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.updateBookingRequestService(reqId, bookingReq),HttpStatus.OK);
	}
	
	@GetMapping(value="/{reqId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// both landlord and tenant can have access
	public ResponseEntity<BookingRequest> getBookingRequest(@PathVariable int reqId) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.viewBookingRequestService(reqId),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{reqId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// both landlord and tenant can have access
	public ResponseEntity<BookingRequest> removeBookingRequest(@PathVariable int reqId) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.deleteBookingRequestService(reqId),HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// only for admin
	public ResponseEntity<List<BookingRequest>> getAllBookingRequests(){
		return new ResponseEntity<>(bookingrequestService.viewAllBookingRequestService(),HttpStatus.OK);
	}
	
	@GetMapping(value="/approved",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// only for admin
	public ResponseEntity<List<BookingRequest>> getAllApprovedBookingRequests(){
		return new ResponseEntity<>(bookingrequestService.getAllApprovedBookingRequestsService(),HttpStatus.OK);
	}
	
	@PutMapping(value="/approval",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// accessible only to landlord
	public ResponseEntity<BookingRequest> updateBookingRequestApproval(@RequestBody BookingRequestApprovalDto bookingReqApprovalDto) throws BookingRequestNotFoundException{
		return new ResponseEntity<>(bookingrequestService.updateBookingRequestApproval(bookingReqApprovalDto.getReqId(), bookingReqApprovalDto.isApproved()),HttpStatus.OK);
	}
}
