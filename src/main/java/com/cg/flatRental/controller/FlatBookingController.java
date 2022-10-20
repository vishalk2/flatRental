package com.cg.flatRental.controller;

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

import com.cg.flatRental.entity.FlatBooking;
import com.cg.flatRental.exceptions.FlatBookingNotFoundException;
import com.cg.flatRental.service.IFlatBookingService;

@RestController
@RequestMapping("/flatbooking")
public class FlatBookingController {
	
	@Autowired
	private IFlatBookingService flatbookingService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<FlatBooking> addFlatBooking(@RequestBody FlatBooking flatBooking){
		return new ResponseEntity<>(flatbookingService.addFlatBookingService(flatBooking),HttpStatus.OK);
	}
	
	@PutMapping(value="/{bookingId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<FlatBooking> updateFlatBooking(@PathVariable int bookingId, FlatBooking flatBooking) throws FlatBookingNotFoundException{
		return new ResponseEntity<>(flatbookingService.updateFlatBookingService(bookingId, flatBooking),HttpStatus.OK);
	}
	
	@GetMapping(value="/{bookingId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<FlatBooking> getFlatBooking(@PathVariable int bookingId) throws FlatBookingNotFoundException{
		return new ResponseEntity<>(flatbookingService.viewFlatBookingService(bookingId),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{bookingId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<FlatBooking> removeFlatBooking(@PathVariable int bookingId) throws FlatBookingNotFoundException{
		return new ResponseEntity<>(flatbookingService.deleteFlatBookingService(bookingId),HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<FlatBooking>> getAllFlatBooking(){
		return new ResponseEntity<>(flatbookingService.viewAllFlatBookingService(),HttpStatus.OK);
	}
}

