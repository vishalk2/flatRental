package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.exceptions.LandLordNotFoundException;

public interface ILandLordService {
	
	public LandLord addLandLordService(LandLord landlord);
	
	public LandLord deleteLandLordService(int landlordId) throws LandLordNotFoundException;
	
	public LandLord getLandLordService(int landlordId) throws LandLordNotFoundException;
	
	public LandLord updateLandLordService(int landlordId, LandLord landlord) throws LandLordNotFoundException;
	
	public List<LandLord> viewAllLandLordService();
	
	public int getUserIdByUserName(String userName) throws LandLordNotFoundException;
	
	public boolean isValidLandLord(String userName, String password);
	
	public LandLord updateLandLordAgeService(int userId, int newAge) throws LandLordNotFoundException;
	
	public LandLord updateLandLordPhoneNumberService(int userId, long phoneNumber) throws LandLordNotFoundException;
	
	public LandLord updateLandLordEmailService(int userId, String email) throws LandLordNotFoundException;
}

