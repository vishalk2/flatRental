package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.TenantNotFoundException;

public interface ITenantService {
	
	public Tenant addTenantService(Tenant tenant);
	
	public Tenant deleteTenantService(int tenantId) throws TenantNotFoundException;
	
	public Tenant getTenantService(int tenantId) throws TenantNotFoundException;
	
	public Tenant updateTenantService(int tenantId, Tenant tenant) throws TenantNotFoundException;
	
	public List<Tenant> viewAllTenantService();
	
	public int getUserIdByUserName(String userName) throws TenantNotFoundException;
	
	public boolean isValidTenant(String userName, String password);
	
	public Tenant updateTenantAgeService(int userId, int newAge) throws TenantNotFoundException;
	
	public Tenant updateTenantPhoneNumberService(int userId, long phoneNumber) throws TenantNotFoundException;
	
	public Tenant updateTenantEmailService(int userId, String email) throws TenantNotFoundException;
}

