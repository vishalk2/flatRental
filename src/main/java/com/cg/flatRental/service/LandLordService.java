package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.exceptions.LandLordNotFoundException;
import com.cg.flatRental.repository.ILandLordRepository;

@Component
public class LandLordService implements ILandLordService {
	
	@Autowired
	private ILandLordRepository landlordRepository;

	@Override
	public LandLord addLandLordService(LandLord landlord) {
		LandLord newLandLord = landlordRepository.save(landlord);
		return newLandLord;
	}

	@Override
	public LandLord deleteLandLordService(int landlordId) throws LandLordNotFoundException {
		Optional<LandLord> landlord = landlordRepository.findById(landlordId);
		if(landlord.isPresent()) {
			LandLord newLandLord = landlord.get();
			landlordRepository.deleteById(landlordId);
			return newLandLord;
		}
		else {
			throw new LandLordNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord getLandLordService(int landlordId) throws LandLordNotFoundException {
		Optional<LandLord> landlord = landlordRepository.findById(landlordId);
		if(landlord.isPresent()) {
			LandLord newLandLord = landlord.get();
			return newLandLord;
		}
		else {
			throw new LandLordNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord updateLandLordService(int landlordId, LandLord landlord) throws LandLordNotFoundException {
		Optional<LandLord> optionalLandlord = landlordRepository.findById(landlordId);
		if(optionalLandlord.isPresent()) {
			landlordRepository.save(landlord);
			return optionalLandlord.get();
		}
		else {
			throw new LandLordNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public List<LandLord> viewAllLandLordService() {
		List<LandLord> landlordList = new ArrayList<>();
		Iterable<LandLord> landlords = landlordRepository.findAll();
		landlords.forEach(ll->landlordList.add(ll));
		return landlordList;
	}

	@Override
	public int getUserIdByUserName(String userName) throws LandLordNotFoundException {
		int userId = landlordRepository.findByUserName(userName).getUserId();
		return userId;
	}

	@Override
	public boolean isValidLandLord(String userName, String password) {
		return landlordRepository.findByUserNameAndPassword(userName, password)!=null? true :false;
	}

	@Override
	public LandLord updateLandLordAgeService(int userId, int newAge) throws LandLordNotFoundException {
		int l = landlordRepository.updateLandLordAge(userId, newAge);
		if(l>0) {
			return getLandLordService(userId);
		}
		else {
			throw new LandLordNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord updateLandLordPhoneNumberService(int userId, long phoneNumber) throws LandLordNotFoundException {
		int l = landlordRepository.updateLandLordPhoneNumber(userId, phoneNumber);
		if(l>0) {
			return getLandLordService(userId);
		}
		else {
			throw new LandLordNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord updateLandLordEmailService(int userId, String email) throws LandLordNotFoundException {
		int l = landlordRepository.updateLandLordEmail(userId, email);
		if(l>0) {
			return getLandLordService(userId);
		}
		else {
			throw new LandLordNotFoundException("Landlord details not found!");
		}
	}
	
}

