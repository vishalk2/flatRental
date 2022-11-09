package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flatRental.dto.FlatDto;
import com.cg.flatRental.entity.Address;
import com.cg.flatRental.entity.Amenities;
import com.cg.flatRental.entity.Flat;
import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.entity.Society;
import com.cg.flatRental.exceptions.FlatNotFoundException;
import com.cg.flatRental.iservice.IFlatService;
import com.cg.flatRental.repository.IFlatRepository;
import com.cg.flatRental.repository.ILandLordRepository;
import com.cg.flatRental.repository.ISocietyRepository;

@Service
public class FlatService implements IFlatService {
	
	@Autowired
	private IFlatRepository flatRepository;
	
	@Autowired
	private ILandLordRepository landlordRepository;
	
	@Autowired
	private ISocietyRepository societyRepository;

	@Override
	public Flat addFlatService(FlatDto flatDto) throws FlatNotFoundException {
		Flat flat = converterToDtoFromEntity(flatDto);
		Flat newFlat = flatRepository.save(flat);
		return newFlat;
	}

	@Override
	public Flat deleteFlatService(int flatId) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if(optionalFlat.isPresent()) {
			Flat flat = optionalFlat.get();
			flatRepository.deleteById(flatId);
			return flat;
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	public Flat getFlatService(int flatId) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if(optionalFlat.isPresent()) {
			Flat flat = optionalFlat.get();
			return flat;
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	public Flat updateFlatService(int flatId, Flat flat) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if(optionalFlat.isPresent()) {
			flatRepository.save(flat);
			Flat updatedFlat = optionalFlat.get();
			return updatedFlat;
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	public List<Flat> getAllFlatService() {
		List<Flat> flatList = new ArrayList<>();
		Iterable<Flat> flats = flatRepository.findAll();
		flats.forEach(f->flatList.add(f));
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByRentalCostService(double rentalCost) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByRentalCost(rentalCost);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByFlatTypeService(String flatType) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByFlatType(flatType);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByAreaService(String area) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByArea(area);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByCityService(String city) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByCity(city);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByStateService(String state) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByState(state);
		return flatList;

	}

	@Override
	public List<Flat> viewAllFlatsByCountryService(String country) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByCountry(country);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByPincodeService(int pincode) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByPincode(pincode);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsBySquareFeetService(double squareFeet) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsBySquareFeet(squareFeet);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsWithGardenService(boolean garden) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsFlatsWithGarden(garden);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsWithSwimmingPoolService(boolean swimmingPool) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsFlatsWithSwimmingPool(swimmingPool);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsWithCarParkingService(boolean carParking) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsWithCarparking(carParking);
		return flatList;
	}

	@Override
	public List<Flat> viewAllFlatsByFacingService(String houseFacing) {
		List<Flat> flatList = new ArrayList<>();
		flatList = flatRepository.findFlatsByFacing(houseFacing);
		return flatList;
	}
	
	public Flat converterToDtoFromEntity(FlatDto flatDto) throws FlatNotFoundException {
		long landlordId = flatDto.getLandlordId();
		int societyId = flatDto.getSocietyId();
		Optional<LandLord> optionalLandlord = landlordRepository.findById(landlordId);
		Optional<Society> optionalSociety = societyRepository.findById(societyId);
		if(optionalLandlord.isPresent() && optionalSociety.isPresent()) {
			
			LandLord landlord = optionalLandlord.get();
			Society society = optionalSociety.get();
			
			Flat flat = new Flat();
			
			flat.setApproved(false); // approved by admin
			flat.setAvailable(false); // should be set by landlord
			flat.setFlatLandLord(landlord);
			flat.setFlatNo(flatDto.getFlatNo());
			flat.setFlatType(flatDto.getFlatType());
			flat.setRentalCost(flatDto.getRentalCost());
			flat.setFlatSociety(society);
			
			Address flatAddress = new Address();
			flatAddress.setArea(flatDto.getArea());
			flatAddress.setCity(flatDto.getCity());
			flatAddress.setState(flatDto.getState());
			flatAddress.setCountry(flatDto.getCountry());
			flatAddress.setPinCode(flatDto.getPincode());
			flat.setFlatAddress(flatAddress);
			
			Amenities flatAmenities = new Amenities();
			flatAmenities.setGarden(flatDto.isGarden());
			flatAmenities.setSwimmingPool(flatDto.isSwimmingPool());
			flatAmenities.setCarParking(flatDto.isCarParking());
			flatAmenities.setHouseFacing(flatDto.getHouseFacing());
			flatAmenities.setSquareFeet(flatDto.getSquareFeet());
			flat.setFlatAmenities(flatAmenities);
			
			return flat;
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	@Transactional
	public Flat updateFlatApprovalService(int flatId, boolean approved) throws FlatNotFoundException {
		int f = flatRepository.updateFlatApproval(flatId, approved);
		if(f>0) {
			return getFlatService(flatId);
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	@Transactional
	public Flat updateFlatAvailabilityService(int flatId, boolean available) throws FlatNotFoundException {
		int f = flatRepository.updateFlatAvailability(flatId, available);
		if(f>0) {
			return getFlatService(flatId);
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	@Transactional
	public Flat updateFlatAddress(int flatId, Address address) throws FlatNotFoundException {
		int f = flatRepository.updateFlatAddress(flatId, address.getArea(), address.getCity(),
				address.getState(), address.getCountry(), address.getPinCode());
		if(f>0) {
			return getFlatService(flatId);
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}

	@Override
	@Transactional
	public Flat updateFlatAmenities(int flatId, Amenities amenities) throws FlatNotFoundException {
		int f = flatRepository.updateFlatAmenities(flatId, amenities.isGarden(), amenities.isSwimmingPool(),
				amenities.isCarParking(), amenities.getHouseFacing(), amenities.getSquareFeet());
		if(f>0) {
			return getFlatService(flatId);
		}
		else {
			 throw new FlatNotFoundException("Flat details not found!");
		}
	}
}

