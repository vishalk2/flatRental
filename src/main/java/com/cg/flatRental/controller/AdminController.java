package com.cg.flatRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.entity.Admin;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.IAdminService;

@Validated
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Admin> addAdmin(@RequestBody @Valid Admin admin){
		return new ResponseEntity<>(adminService.addAdminService(admin), HttpStatus.OK);
	}
	
	@GetMapping(value="/{adminId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Admin> viewAdmin(@PathVariable long adminId) throws UserNotFoundException{
		return new ResponseEntity<>(adminService.getAdminService(adminId), HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<List<Admin>> viewAllAdmin(){
		return new ResponseEntity<>(adminService.getAllAdminService(), HttpStatus.OK);
	}
}

