package com.cg.flatRental.iservice;

import java.util.List;

import com.cg.flatRental.dto.SocietyDto;
import com.cg.flatRental.entity.Address;
import com.cg.flatRental.entity.Society;
import com.cg.flatRental.exceptions.SocietyNotFoundException;

public interface ISocietyService {
	
	public Society updateSocietyApprovalService(int societyId, boolean approved) throws SocietyNotFoundException;
	
	public Society addSocietyService(SocietyDto societyDto) throws SocietyNotFoundException;
	
	public Society updateSocietyService(int societyId, Society society) throws SocietyNotFoundException;
	
	public Society removeSocietyService(int societyId) throws SocietyNotFoundException;
	
	public Society getSocietyServiceById(int societyId) throws SocietyNotFoundException;
	
	public List<Society> readAllSocietyService();
	
	public List<Society> getAllSocietyServiceByName(String societyName);
	
	public List<Society> getAllSocietyServiceByArea(String area);
	
	public List<Society> getAllSocietyServiceByCity(String city);
	
	public List<Society> getAllSocietyServiceByState(String state);
	
	public List<Society> getAllSocietyServiceByCountry(String country);
	
	public List<Society> getAllSocietyServiceByPincode(int pincode);
	
	public Society updateSocietyAddressService(int societyId, Address address) throws SocietyNotFoundException;
	
	public Society updateSocietyName(int societyId, String societyName) throws SocietyNotFoundException;
}

