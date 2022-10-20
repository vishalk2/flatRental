package com.cg.flatRental.iservice;

import java.util.List;

import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.UserNotFoundException;

public interface ITenantService {
	
	public Tenant addTenantService(Tenant tenant);
	
	public Tenant deleteTenantService(long tenantId) throws UserNotFoundException;
	
	public Tenant getTenantService(long tenantId) throws UserNotFoundException;
	
	public Tenant updateTenantService(long tenantId, Tenant tenant) throws UserNotFoundException;
	
	public List<Tenant> viewAllTenantService();
	
	public long getUserIdByUserName(String userName) throws UserNotFoundException;
	
	public boolean isValidTenant(String userName, String password);
	
	public Tenant updateTenantAgeService(long userId, int newAge) throws UserNotFoundException;
	
	public Tenant updateTenantPhoneNumberService(long userId, long phoneNumber) throws UserNotFoundException;
	
	public Tenant updateTenantEmailService(long userId, String email) throws UserNotFoundException;
}
