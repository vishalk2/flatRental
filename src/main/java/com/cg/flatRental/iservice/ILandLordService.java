package com.cg.flatRental.iservice;

import java.util.List;

import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.exceptions.UserNotFoundException;

public interface ILandLordService {
	
	public LandLord addLandLordService(LandLord landlord);
	
	public LandLord deleteLandLordService(long landlordId) throws UserNotFoundException;
	
	public LandLord getLandLordService(long landlordId) throws UserNotFoundException;
	
	public LandLord updateLandLordService(long landlordId, LandLord landlord) throws UserNotFoundException;
	
	public List<LandLord> viewAllLandLordService();
	
	public long getUserIdByUserName(String userName) throws UserNotFoundException;
	
	public boolean isValidLandLord(String userName, String password);
	
	public LandLord updateLandLordAgeService(long userId, int newAge) throws UserNotFoundException;
	
	public LandLord updateLandLordPhoneNumberService(long userId, long phoneNumber) throws UserNotFoundException;
	
	public LandLord updateLandLordEmailService(long userId, String email) throws UserNotFoundException;
}

