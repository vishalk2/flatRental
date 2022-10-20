package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.ITenantService;
import com.cg.flatRental.repository.ITenantRepository;

@Service
public class TenantService implements ITenantService{
	
	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public Tenant addTenantService(Tenant tenant) {
		Tenant newTenant = tenantRepository.save(tenant);
		return newTenant;
	}

	@Override
	public Tenant deleteTenantService(long tenantId) throws UserNotFoundException {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isPresent()) {
			Tenant newTenant = optionalTenant.get();
			tenantRepository.deleteById(tenantId);
			return newTenant;
		}
		else {
			 throw new UserNotFoundException("Tenant details not found!");
		}
	}

	@Override
	public Tenant getTenantService(long tenantId) throws UserNotFoundException {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isPresent()) {
			Tenant newTenant = optionalTenant.get();
			return newTenant;
		}
		else {
			 throw new UserNotFoundException("Tenant details not found!");
		}
	}

	@Override
	public Tenant updateTenantService(long tenantId, Tenant tenant) throws UserNotFoundException {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isPresent()) {
			tenantRepository.save(tenant);
			return optionalTenant.get();
			
		}
		else {
			 throw new UserNotFoundException("Tenant details not found!");
		}
	}

	@Override
	public List<Tenant> viewAllTenantService() {
		List<Tenant> tenantList = new ArrayList<>();
		Iterable<Tenant> tenants = tenantRepository.findAll();
		tenants.forEach(t->tenantList.add(t));
		return tenantList;
	}

	@Override
	public long getUserIdByUserName(String userName) throws UserNotFoundException {
		long userId = tenantRepository.findByUserName(userName).getUserId();
		return userId;
	}

	@Override
	public boolean isValidTenant(String userName, String password) {
		return tenantRepository.findByUserNameAndPassword(userName, password)!=null? true :false;
	}

	@Override
	public Tenant updateTenantAgeService(long tenantId, int newAge) throws UserNotFoundException {
		int t = tenantRepository.updateTenantAge(tenantId, newAge);
		if(t>0) {
			return getTenantService(tenantId);
		}
		else {
			 throw new UserNotFoundException("Tenant details not found! Tenant could not be updated!");
		}
	}

	@Override
	public Tenant updateTenantPhoneNumberService(long tenantId, long phoneNumber) throws UserNotFoundException {
		int t = tenantRepository.updateTenantPhoneNumber(tenantId, phoneNumber);
		if(t>0) {
			return getTenantService(tenantId);
		}
		else {
			 throw new UserNotFoundException("Tenant details not found! Tenant could not be updated!");
		}
	}

	@Override
	public Tenant updateTenantEmailService(long tenantId, String email) throws UserNotFoundException {
		int t = tenantRepository.updateTenantEmail(tenantId, email);
		if(t>0) {
			return getTenantService(tenantId);
		}
		else {
			 throw new UserNotFoundException("Tenant details not found! Tenant could not be updated!");
		}
	}
}
