package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.ILandLordService;
import com.cg.flatRental.repository.ILandLordRepository;

@Service
public class LandLordService implements ILandLordService {
	
	@Autowired
	private ILandLordRepository landlordRepository;

	@Override
	public LandLord addLandLordService(LandLord landlord) {
		LandLord newLandLord = landlordRepository.save(landlord);
		return newLandLord;
	}

	@Override
	public LandLord deleteLandLordService(long landlordId) throws UserNotFoundException {
		Optional<LandLord> landlord = landlordRepository.findById(landlordId);
		if(landlord.isPresent()) {
			LandLord newLandLord = landlord.get();
			landlordRepository.deleteById(landlordId);
			return newLandLord;
		}
		else {
			 throw new UserNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord getLandLordService(long landlordId) throws UserNotFoundException {
		Optional<LandLord> landlord = landlordRepository.findById(landlordId);
		if(landlord.isPresent()) {
			LandLord newLandLord = landlord.get();
			return newLandLord;
		}
		else {
			 throw new UserNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord updateLandLordService(long landlordId, LandLord landlord) throws UserNotFoundException {
		Optional<LandLord> optionalLandlord = landlordRepository.findById(landlordId);
		if(optionalLandlord.isPresent()) {
			landlordRepository.save(landlord);
			return optionalLandlord.get();
		}
		else {
			 throw new UserNotFoundException("Landlord details not found!");
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
	public long getUserIdByUserName(String userName) throws UserNotFoundException {
		long userId = landlordRepository.findByUserName(userName).getUserId();
		return userId;
	}

	@Override
	public boolean isValidLandLord(String userName, String password) {
		return landlordRepository.findByUserNameAndPassword(userName, password)!=null? true :false;
	}

	@Override
	public LandLord updateLandLordAgeService(long userId, int newAge) throws UserNotFoundException {
		int l = landlordRepository.updateLandLordAge(userId, newAge);
		if(l>0) {
			return getLandLordService(userId);
		}
		else {
			 throw new UserNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord updateLandLordPhoneNumberService(long userId, long phoneNumber) throws UserNotFoundException {
		int l = landlordRepository.updateLandLordPhoneNumber(userId, phoneNumber);
		if(l>0) {
			return getLandLordService(userId);
		}
		else {
			 throw new UserNotFoundException("Landlord details not found!");
		}
	}

	@Override
	public LandLord updateLandLordEmailService(long userId, String email) throws UserNotFoundException {
		int l = landlordRepository.updateLandLordEmail(userId, email);
		if(l>0) {
			return getLandLordService(userId);
		}
		else {
			 throw new UserNotFoundException("Landlord details not found!");
		}
	}
	
}
