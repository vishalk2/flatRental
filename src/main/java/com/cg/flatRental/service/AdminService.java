package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatRental.entity.Admin;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.IAdminService;
import com.cg.flatRental.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private IAdminRepository adminRepository;

	@Override
	public Admin addAdminService(Admin admin) {
		Admin newAdmin = adminRepository.save(admin);
		return newAdmin;
	}

	@Override
	public Admin getAdminService(long adminId) throws UserNotFoundException {
		Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
		if(optionalAdmin.isPresent()) {
			Admin admin = optionalAdmin.get();
			return admin;
		}
		else {
			 throw new UserNotFoundException("Admin Details not found!");
		}
	}

	@Override
	public List<Admin> getAllAdminService() {
		List<Admin> adminList = new ArrayList<>();
		Iterable<Admin> admins = adminRepository.findAll();
		admins.forEach(a->adminList.add(a));
		return adminList;
	}
}
