package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.entity.Admin;
import com.cg.flatRental.exceptions.AdminNotFoundException;

public interface IAdminService {
	
	public Admin addAdminService(Admin admin);
	
	public Admin getAdminService(int adminId) throws AdminNotFoundException;
	
	public List<Admin> getAllAdminService();
}
