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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.dto.FlatApprovalDto;
import com.cg.flatRental.dto.FlatAvailableDto;
import com.cg.flatRental.dto.FlatDto;
import com.cg.flatRental.entity.Flat;
import com.cg.flatRental.exceptions.FlatNotFoundException;
import com.cg.flatRental.service.IFlatService;

@Validated
@RestController
@RequestMapping("/flat")
public class FlatController {
	
	@Autowired
	private IFlatService flatService;
	
	@PutMapping(value="/approval/{flatId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// accessible only to admin
	public ResponseEntity<Flat> updateFlatApproval(@RequestBody FlatApprovalDto flatApprovalDto) throws FlatNotFoundException{
		return new ResponseEntity<>(flatService.updateFlatApprovalService(flatApprovalDto.getFlatId(), flatApprovalDto.isApproved()),HttpStatus.OK);
	}
	
	@PutMapping(value="/available/{flatId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	// accessible only to landlord
	public ResponseEntity<Flat> updateFlatAvailable(@RequestBody FlatAvailableDto flatAvailableDto) throws FlatNotFoundException{
		return new ResponseEntity<>(flatService.updateFlatAvailabilityService(flatAvailableDto.getFlatId(), flatAvailableDto.isAvailable()),HttpStatus.OK);
	}
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Flat> addFlat(@RequestBody @Valid FlatDto flatDto) throws FlatNotFoundException{
		return new ResponseEntity<>(flatService.addFlatService(flatDto),HttpStatus.OK);
	}
	
	@PutMapping(value="/{flatId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Flat> updateFlat(@PathVariable int flatId, @Valid Flat flat) throws FlatNotFoundException{
		return new ResponseEntity<>(flatService.updateFlatService(flatId, flat),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{flatId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Flat> removeFlat(@PathVariable int flatId) throws FlatNotFoundException{
		return new ResponseEntity<>(flatService.deleteFlatService(flatId),HttpStatus.OK);
	}
	
	@GetMapping(value="/{flatId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Flat> readFlat(@PathVariable int flatId) throws FlatNotFoundException{
		return new ResponseEntity<>(flatService.getFlatService(flatId), HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlats(){
		List<Flat> flatList = flatService.getAllFlatService();
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/cost",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByRentalCost(@RequestParam("rentalcost") double rentalcost){
		List<Flat> flatList = flatService.viewAllFlatsByRentalCostService(rentalcost);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/type",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByFlatType(@RequestParam("flattype") String flattype){
		List<Flat> flatList = flatService.viewAllFlatsByFlatTypeService(flattype);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/area",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByArea(@RequestParam("area") String area){
		List<Flat> flatList = flatService.viewAllFlatsByAreaService(area);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/city",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByCity(@RequestParam("city") String city){
		List<Flat> flatList = flatService.viewAllFlatsByCityService(city);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/state",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByState(@RequestParam("state") String state){
		List<Flat> flatList = flatService.viewAllFlatsByStateService(state);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/country",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByCountry(@RequestParam("country") String country){
		List<Flat> flatList = flatService.viewAllFlatsByCountryService(country);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/pincode",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByPincode(@RequestParam("pincode") int pincode){
		List<Flat> flatList = flatService.viewAllFlatsByPincodeService(pincode);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/squarefeet",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsBySquareFeet(@RequestParam("squarefeet") double squarefeet){
		List<Flat> flatList = flatService.viewAllFlatsBySquareFeetService(squarefeet);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/garden",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsWithGarden(@RequestParam("hasgarden") boolean hasgarden){
		List<Flat> flatList = flatService.viewAllFlatsWithGardenService(hasgarden);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/swimmmingpool",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsWithSwimmingPool(@RequestParam("hasswimmingpool") boolean hasswimmingpool){
		List<Flat> flatList = flatService.viewAllFlatsWithSwimmingPoolService(hasswimmingpool);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/carparking",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsWithCarParking(@RequestParam("hascarparking") boolean hascarparking){
		List<Flat> flatList = flatService.viewAllFlatsWithCarParkingService(hascarparking);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
	
	@GetMapping(value="/search/housefacing",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<Flat>> readAllFlatsByFacing(@RequestParam("housefacing") String housefacing){
		List<Flat> flatList = flatService.viewAllFlatsByFacingService(housefacing);
		return new ResponseEntity<>(flatList, HttpStatus.OK);
	}
}
