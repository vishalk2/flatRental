package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.flatRental.entity.Society;
import com.cg.flatRental.exceptions.SocietyNotFoundException;
import com.cg.flatRental.repository.ISocietyRepository;

@Component
public class SocietyService implements ISocietyService {
	
	@Autowired
	private ISocietyRepository societyRepository;

	@Override
	public Society addSocietyService(Society society) {
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
}

