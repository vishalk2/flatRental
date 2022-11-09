package com.cg.flatRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.dto.TenantAgeUpdateDto;
import com.cg.flatRental.dto.TenantEmailUpdateDto;
import com.cg.flatRental.dto.TenantPhoneNumberUpdateDto;
import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.iservice.ITenantService;

@Validated
@RestController
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
	private ITenantService tenantService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<Tenant> addTenant(@RequestBody @Valid Tenant tenant){
		return new ResponseEntity<>(tenantService.addTenantService(tenant), HttpStatus.OK);
	}
	
	@PutMapping(value="/{userId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<Tenant> updateTenant(@PathVariable long userId, @Valid Tenant tenant) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.updateTenantService(userId, tenant), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{userId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin') or hasAuthority('tenant')")
	public ResponseEntity<Tenant> removeTenant(@PathVariable long userId) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.deleteTenantService(userId), HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Tenant> viewTenant(@PathVariable long userId) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.getTenantService(userId), HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<List<Tenant>> viewAllTenant(){
		return new ResponseEntity<>(tenantService.viewAllTenantService(), HttpStatus.OK);
	}
	
	@GetMapping(value="/valid/{username}/{password}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin') or hasAuthority('tenant')")
	public ResponseEntity<Boolean> isValidTenant(@PathVariable String username, @PathVariable String password){
		return new ResponseEntity<>(tenantService.isValidTenant(username, password),HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{username}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('admin') or hasAuthority('tenant')")
	public ResponseEntity<Long> getTenantId(@PathVariable String username) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.getUserIdByUserName(username),HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/age",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<Tenant> updateTenantAge(@RequestBody TenantAgeUpdateDto tenantAgeUpdateDto) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.updateTenantAgeService(tenantAgeUpdateDto.getUserId(),tenantAgeUpdateDto.getTenantAge()), HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/phonenumber",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<Tenant> updateTenantPhoneNumber(@RequestBody TenantPhoneNumberUpdateDto tenantPhoneNumberUpdateDto) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.updateTenantPhoneNumberService(tenantPhoneNumberUpdateDto.getUserId(), tenantPhoneNumberUpdateDto.getTenantPhoneNumber()), HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/email",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('tenant')")
	public ResponseEntity<Tenant> updateTenantEmail(@RequestBody TenantEmailUpdateDto tenantEmailUpdateDto) throws UserNotFoundException{
		return new ResponseEntity<>(tenantService.updateTenantEmailService(tenantEmailUpdateDto.getUserId(), tenantEmailUpdateDto.getEmailId()), HttpStatus.OK);
	}
}
