package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.TenantNotFoundException;
import com.cg.flatRental.repository.ITenantRepository;

@Component
public class TenantService implements ITenantService{
	
	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public Tenant addTenantService(Tenant tenant) {
		Tenant newTenant = tenantRepository.save(tenant);
		return newTenant;
	}

	@Override
	public Tenant deleteTenantService(int tenantId) throws TenantNotFoundException {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isPresent()) {
			Tenant newTenant = optionalTenant.get();
			tenantRepository.deleteById(tenantId);
			return newTenant;
		}
		else {
			throw new TenantNotFoundException("Tenant details not found!");
		}
	}

	@Override
	public Tenant getTenantService(int tenantId) throws TenantNotFoundException {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isPresent()) {
			Tenant newTenant = optionalTenant.get();
			return newTenant;
		}
		else {
			throw new TenantNotFoundException("Tenant details not found!");
		}
	}

	@Override
	public Tenant updateTenantService(int tenantId, Tenant tenant) throws TenantNotFoundException {
		Optional<Tenant> optionalTenant = tenantRepository.findById(tenantId);
		if(optionalTenant.isPresent()) {
			tenantRepository.save(tenant);
			return optionalTenant.get();
			
		}
		else {
			throw new TenantNotFoundException("Tenant details not found!");
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
	public int getUserIdByUserName(String userName) throws TenantNotFoundException {
		int userId = tenantRepository.findByUserName(userName).getUserId();
		return userId;
	}

	@Override
	public boolean isValidTenant(String userName, String password) {
		return tenantRepository.findByUserNameAndPassword(userName, password)!=null? true :false;
	}

	@Override
	public Tenant updateTenantAgeService(int tenantId, int newAge) throws TenantNotFoundException {
		int t = tenantRepository.updateTenantAge(tenantId, newAge);
		if(t>0) {
			return getTenantService(tenantId);
		}
		else {
			throw new TenantNotFoundException("Tenant details not found! Tenant could not be updated!");
		}
	}

	@Override
	public Tenant updateTenantPhoneNumberService(int tenantId, long phoneNumber) throws TenantNotFoundException {
		int t = tenantRepository.updateTenantPhoneNumber(tenantId, phoneNumber);
		if(t>0) {
			return getTenantService(tenantId);
		}
		else {
			throw new TenantNotFoundException("Tenant details not found! Tenant could not be updated!");
		}
	}

	@Override
	public Tenant updateTenantEmailService(int tenantId, String email) throws TenantNotFoundException {
		int t = tenantRepository.updateTenantEmail(tenantId, email);
		if(t>0) {
			return getTenantService(tenantId);
		}
		else {
			throw new TenantNotFoundException("Tenant details not found! Tenant could not be updated!");
		}
	}
}

