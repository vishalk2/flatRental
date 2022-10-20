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

import com.cg.flatRental.entity.Society;
import com.cg.flatRental.exceptions.SocietyNotFoundException;
import com.cg.flatRental.service.ISocietyService;

@Validated
@RestController
@RequestMapping("/society")
public class SocietyController {
	
	@Autowired
	private ISocietyService societyService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Society> addSociety(@RequestBody @Valid Society society){
		return new ResponseEntity<>(societyService.addSocietyService(society), HttpStatus.OK);
	}
	
	@PutMapping(value="/{societyId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Society> updateSociety(@PathVariable int societyId, @Valid Society society) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.updateSocietyService(societyId, society), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{societyId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Society> deleteSociety(@PathVariable int societyId) throws SocietyNotFoundException{
		return new ResponseEntity<>(societyService.removeSocietyService(societyId), HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Society>> readAllSocities(){
		System.out.println("read all socity is working ...");
		List<Society> societiesList = societyService.readAllSocietyService();
		return new ResponseEntity<>(societiesList, HttpStatus.OK);
	}
	
	@GetMapping(value="/{societyId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
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
}
