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

import com.cg.flatRental.dto.SocietyAddressDto;
import com.cg.flatRental.dto.SocietyApprovalDto;
import com.cg.flatRental.dto.SocietyDto;
import com.cg.flatRental.dto.SocietyNameDto;
import com.cg.flatRental.entity.Address;
import com.cg.flatRental.entity.Society;
import com.cg.flatRental.exceptions.SocietyNotFoundException;
import com.cg.flatRental.iservice.ISocietyService;

@Validated
@RestController
@RequestMapping("/society")
public class SocietyController {
	
	@Autowired
	private ISocietyService societyService;
	
	@PutMapping(value="/approval",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Society> updateSocietyApproval(@RequestBody SocietyApprovalDto societyApprovalDto) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.updateSocietyApprovalService(societyApprovalDto.getSocietyId(), societyApprovalDto.isApproved()),HttpStatus.OK);
	}
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('landlord')")
	public ResponseEntity<Society> addSociety(@RequestBody @Valid SocietyDto society) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.addSocietyService(society), HttpStatus.OK);
	}
	
	@PutMapping(value="/{societyId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('landlord')")
	public ResponseEntity<Society> updateSociety(@PathVariable int societyId, @Valid Society society) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.updateSocietyService(societyId, society), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{societyId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin') or hasAuthority('landlord')")
	public ResponseEntity<Society> deleteSociety(@PathVariable int societyId) throws SocietyNotFoundException {
		return new ResponseEntity<>(societyService.removeSocietyService(societyId), HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocities(){
		List<Society> societiesList = societyService.readAllSocietyService();
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/{societyId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin') or hasAuthority('landlord')")
	public ResponseEntity<Society> getSociety(@PathVariable int societyId) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.getSocietyServiceById(societyId), HttpStatus.OK);
	}
	
	@GetMapping(value="/name",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocitiesByName(String societyName){
		List<Society> societiesList = societyService.getAllSocietyServiceByName(societyName);
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/area",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocitiesByArea(String area){
		List<Society> societiesList = societyService.getAllSocietyServiceByArea(area);
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/city",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocitiesByCity(String city){
		List<Society> societiesList = societyService.getAllSocietyServiceByCity(city);
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/state",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocitiesByState(String state){
		List<Society> societiesList = societyService.getAllSocietyServiceByState(state);
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/country",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocitiesByCountry(String country){
		List<Society> societiesList = societyService.getAllSocietyServiceByCountry(country);
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/pincode",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocitiesByPincode(int pincode){
		List<Society> societiesList = societyService.getAllSocietyServiceByPincode(pincode);
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/address",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('landlord')")
	public ResponseEntity<Society> updateSocietyAddress(@RequestBody SocietyAddressDto societyAddressDto) throws SocietyNotFoundException{
		Address address = new Address();
		address.setArea(societyAddressDto.getArea());
		address.setCity(societyAddressDto.getCity());
		address.setState(societyAddressDto.getState());
		address.setCountry(societyAddressDto.getCountry());
		address.setPinCode(societyAddressDto.getPincode());
		return new ResponseEntity<>(societyService.updateSocietyAddressService(societyAddressDto.getSocietyId(), address),HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/name",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('landlord')")
	public ResponseEntity<Society> updateSocietyName(@RequestBody SocietyNameDto societyNameDto) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.updateSocietyName(societyNameDto.getSocietyId(), societyNameDto.getSocietyName()),HttpStatus.OK);
	}
}
