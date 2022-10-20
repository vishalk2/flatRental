package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flatRental.dto.SocietyDto;
import com.cg.flatRental.entity.Address;
import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.entity.Society;
import com.cg.flatRental.exceptions.SocietyNotFoundException;
import com.cg.flatRental.iservice.ISocietyService;
import com.cg.flatRental.repository.ILandLordRepository;
import com.cg.flatRental.repository.ISocietyRepository;

@Service
public class SocietyService implements ISocietyService {
	
	@Autowired
	private ISocietyRepository societyRepository;
	
	@Autowired
	private ILandLordRepository landlordRepository;

	@Override
	public Society addSocietyService(SocietyDto societyDto) throws SocietyNotFoundException {
		Society society = converterToDtoFromEntity(societyDto);
		Society newSociety = societyRepository.save(society);
		return newSociety;
	}

	@Override
	public Society updateSocietyService(int societyId, Society society) throws SocietyNotFoundException {
		Optional<Society> optionalSociety = societyRepository.findById(societyId);
		if(optionalSociety.isPresent()) {
			societyRepository.save(society);
			Society updatedSociety = optionalSociety.get();
			return updatedSociety;
		}
		else {
			 throw new SocietyNotFoundException("Society details not found!");
		}
	}

	@Override
	public Society removeSocietyService(int societyId) throws SocietyNotFoundException {
		Optional<Society> optionalSociety = societyRepository.findById(societyId);
		if(optionalSociety.isPresent()) {
			Society society = optionalSociety.get();
			societyRepository.deleteById(societyId);
			return society;
		}
		else {
			 throw new SocietyNotFoundException("Society details not found!");
		}
	}

	@Override
	public List<Society> readAllSocietyService() {
		List<Society> societyList = new ArrayList<>();
		Iterable<Society> societies = societyRepository.findAll();
		societies.forEach(s->societyList.add(s));
		return societyList;
	}

	@Override
	public Society getSocietyServiceById(int societyId) throws SocietyNotFoundException {
		Optional<Society> optionalSociety = societyRepository.findById(societyId);
		if(optionalSociety.isPresent()) {
			Society society = optionalSociety.get();
			return society;
		}
		else {
			 throw new SocietyNotFoundException("Society details not found!");
		}
	}

	@Override
	public List<Society> getAllSocietyServiceByName(String societyName) {
		List<Society> societiesList = societyRepository.findBySocietyName(societyName);
		return societiesList;
	}

	@Override
	public List<Society> getAllSocietyServiceByArea(String area) {
		List<Society> societiesList = societyRepository.filterBySocietyArea(area);
		return societiesList;
	}

	@Override
	public List<Society> getAllSocietyServiceByCity(String city) {
		List<Society> societiesList = societyRepository.filterBySocietyCity(city);
		return societiesList;
	}

	@Override
	public List<Society> getAllSocietyServiceByState(String state) {
		List<Society> societiesList = societyRepository.filterBySocietyState(state);
		return societiesList;
	}

	@Override
	public List<Society> getAllSocietyServiceByCountry(String country) {
		List<Society> societiesList = societyRepository.filterBySocietyCountry(country);
		return societiesList;
	}

	@Override
	public List<Society> getAllSocietyServiceByPincode(int pincode) {
		List<Society> societiesList = societyRepository.filterBySocietyPincode(pincode);
		return societiesList;
	}

	@Override
	@Transactional
	public Society updateSocietyApprovalService(int societyId, boolean approved) throws SocietyNotFoundException {
		int s = societyRepository.updateSocietyApproval(societyId, approved);
		if(s>0) {
			return getSocietyServiceById(societyId);
		}
		else {
			 throw new SocietyNotFoundException("Society could not be approved");
		}
	}
	
	public Society converterToDtoFromEntity(SocietyDto societyDto) throws SocietyNotFoundException {
		long landlordId = societyDto.getLandlordId();
		Optional<LandLord> optionalLandlord = landlordRepository.findById(landlordId);
		if(optionalLandlord.isPresent()) {
			
			LandLord landlord = optionalLandlord.get();
			Address societyAddress = new Address();
			societyAddress.setArea(societyDto.getArea());
			societyAddress.setCity(societyDto.getCity());
			societyAddress.setState(societyDto.getState());
			societyAddress.setCountry(societyDto.getCountry());
			societyAddress.setPinCode(societyDto.getPincode());
			
			Society society = new Society();
			society.setApproved(false);
			society.setSocietyName(societyDto.getSocietyName());
			society.setSocietyLandlord(landlord);
			society.setSocietyAddress(societyAddress);
			
			return society;
		}
		else {
			throw new SocietyNotFoundException("Landlord details could not be found!");
		}
	}

	@Override
	@Transactional
	public Society updateSocietyAddressService(int societyId, Address address) throws SocietyNotFoundException {
		int s = societyRepository.updateSocietyAddress(societyId, address.getArea(), address.getCity(), 
				address.getState(), address.getCountry(), address.getPinCode());
		if(s>0) {
			return getSocietyServiceById(societyId);
		}
		else {
			 throw new SocietyNotFoundException("Society detials could not be found");
		}
	}

	@Override
	@Transactional
	public Society updateSocietyName(int societyId, String societyName) throws SocietyNotFoundException {
		int s = societyRepository.updateSocietyName(societyId, societyName);
		if(s>0) {
			return getSocietyServiceById(societyId);
		}
		else {
			 throw new SocietyNotFoundException("Society detials could not be found");
		}
	}
}
