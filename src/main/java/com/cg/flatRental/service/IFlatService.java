package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.dto.FlatDto;
import com.cg.flatRental.entity.Flat;
import com.cg.flatRental.exceptions.FlatNotFoundException;

public interface IFlatService {
	
	public Flat updateFlatApprovalService(int flatId, boolean approved) throws FlatNotFoundException;
	
	public Flat updateFlatAvailabilityService(int flatId, boolean available) throws FlatNotFoundException;
	
	public Flat addFlatService(FlatDto flatDto) throws FlatNotFoundException;
	
	public Flat deleteFlatService(int flatId) throws FlatNotFoundException;
	
	public Flat getFlatService(int flatId) throws FlatNotFoundException;
	
	public Flat updateFlatService(int flatId, Flat flat) throws FlatNotFoundException;
	
	public List<Flat> getAllFlatService();
	
	public List<Flat> viewAllFlatsByRentalCostService(double rentalCost);
	
	public List<Flat> viewAllFlatsByFlatTypeService(String flatType);
	
	public List<Flat> viewAllFlatsByAreaService(String area);
	
	public List<Flat> viewAllFlatsByCityService(String city);
	
	public List<Flat> viewAllFlatsByStateService(String state);
	
	public List<Flat> viewAllFlatsByCountryService(String country);
	
	public List<Flat> viewAllFlatsByPincodeService(int pincode);
	
	public List<Flat> viewAllFlatsBySquareFeetService(double squareFeet);
	
	public List<Flat> viewAllFlatsWithGardenService(boolean garden);
	
	public List<Flat> viewAllFlatsWithSwimmingPoolService(boolean swimmingPool);
	
	public List<Flat> viewAllFlatsWithCarParkingService(boolean carParking);
	
	public List<Flat> viewAllFlatsByFacingService(String houseFacing);
}
