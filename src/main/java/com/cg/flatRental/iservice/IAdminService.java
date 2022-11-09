package com.cg.flatRental.iservice;

import java.util.List;

import com.cg.flatRental.entity.Admin;
import com.cg.flatRental.exceptions.UserNotFoundException;

public interface IAdminService {
	
	public Admin addAdminService(Admin admin);
	
	public Admin getAdminService(long adminId) throws UserNotFoundException;
	
	public List<Admin> getAllAdminService();
}

