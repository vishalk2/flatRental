package com.cg.flatRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.dto.LandLordAgeUpdateDto;
import com.cg.flatRental.dto.LandLordEmailUpdateDto;
import com.cg.flatRental.dto.LandLordPhoneNumberUpdateDto;
import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.exceptions.LandLordNotFoundException;
import com.cg.flatRental.service.ILandLordService;

@Validated
@RestController
@RequestMapping("/landlord")
public class LandLordController {
	
	@Autowired
	private ILandLordService landlordService;
	
	@PostMapping(produces={"application/json","application/xml"},consumes={"application/json","application/xml"})
	public ResponseEntity<LandLord> addLandLord(@RequestBody @Valid LandLord landlord){
		return new ResponseEntity<>(landlordService.addLandLordService(landlord), HttpStatus.OK);
	}
	
	@PutMapping(value="/{userId}",produces={"application/json","application/xml"}, consumes={"application/json","application/xml"})
	public ResponseEntity<LandLord> updateLandLord(@PathVariable int userId, @Valid LandLord landlord) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.updateLandLordService(userId, landlord), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{userId}",produces={"application/json","application/xml"}, consumes={"application/json","application/xml"})
	public ResponseEntity<LandLord> removeLandLord(@PathVariable int userId) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.deleteLandLordService(userId), HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}",produces={"application/json","application/xml"}, consumes={"application/json","application/xml"})
	public ResponseEntity<LandLord> viewLandLord(@PathVariable int userId) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.getLandLordService(userId), HttpStatus.OK);
	}
	
	@GetMapping(produces={"application/json","application/xml"}, consumes={"application/json","application/xml"})
	public ResponseEntity<List<LandLord>> viewAllLandLord(){
		System.out.println("view all is working ...");
		return new ResponseEntity<>(landlordService.viewAllLandLordService(), HttpStatus.OK);
	}
	
	@GetMapping(value="/valid/{username}/{password}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Boolean> isValidLandLord(@PathVariable String username, @PathVariable String password){
		return new ResponseEntity<>(landlordService.isValidLandLord(username, password),HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{username}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Integer> getLandLordId(@PathVariable String username) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.getUserIdByUserName(username),HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/age",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<LandLord> updateLandLordAge(@RequestBody LandLordAgeUpdateDto landlordAgeUpdateDto) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.updateLandLordAgeService(landlordAgeUpdateDto.getUserId(), landlordAgeUpdateDto.getLandLordAge()), HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/phonenumber",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<LandLord> updateLandLordPhoneNumber(@RequestBody LandLordPhoneNumberUpdateDto landlordPhoneNumberUpdateDto) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.updateLandLordPhoneNumberService(landlordPhoneNumberUpdateDto.getUserId(), landlordPhoneNumberUpdateDto.getLandLordPhoneNumber()), HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/email",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<LandLord> updateLandLordEmail(@RequestBody LandLordEmailUpdateDto landlordEmailUpdateDto) throws LandLordNotFoundException{
		return new ResponseEntity<>(landlordService.updateLandLordEmailService(landlordEmailUpdateDto.getUserId(), landlordEmailUpdateDto.getLandLordEmailId()), HttpStatus.OK);
	}
}