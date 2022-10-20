package com.cg.flatRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.config.JwtTokenUtil;
import com.cg.flatRental.entity.Admin;
import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.entity.Tenant;
import com.cg.flatRental.repository.ILandLordRepository;
import com.cg.flatRental.secure.JwtRequest;
import com.cg.flatRental.secure.UserDto;
import com.cg.flatRental.iservice.IAdminService;
import com.cg.flatRental.iservice.ILandLordService;
import com.cg.flatRental.iservice.ITenantService;
import com.cg.flatRental.service.UserService;
import com.cg.flatRental.secure.JwtResponse;
import com.cg.flatRental.secure.User;


@RestController
@CrossOrigin
public class UserAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ILandLordService landLordService;
	
	@Autowired
	private ITenantService tenantService;
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@PostMapping(value="/register")
		public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception{
		    if(userDto.getUserType().toLowerCase().equals("landlord")){
		    	LandLord landlord = new LandLord();
		    	landlord.setUserName(userDto.getUserName());
		    	landlord.setPassword(bcryptEncoder.encode( userDto.getPassword()));
		    	landlord.setUserType(userDto.getUserType());
		    	landlord.setLandLordName(userDto.getName());
		    	landlord.setLandLordAge(userDto.getUserAge());
		    	landlord.setLandLordPhoneNumber(userDto.getUserPhoneNumber());
		    	landlord.setLandLordEmailId(userDto.getEmailId());
		    	return ResponseEntity.ok(landLordService.addLandLordService(landlord));
		    	//return ResponseEntity.ok(userService.save(userDto));
		    }
		    else if(userDto.getUserType().toLowerCase().equals("tenant")) {
		    	Tenant tenant = new Tenant();
		    	tenant.setUserName(userDto.getUserName());
		    	tenant.setPassword(bcryptEncoder.encode(userDto.getPassword()));
		    	tenant.setUserType(userDto.getUserType());
		    	tenant.setTenantName(userDto.getName());
		    	tenant.setTenantAge(userDto.getUserAge());
		    	tenant.setTenantPhoneNumber(userDto.getUserPhoneNumber());
		    	tenant.setEmailId(userDto.getEmailId());
		    	return ResponseEntity.ok(tenantService.addTenantService(tenant));
		    }
		    else if(userDto.getUserType().toLowerCase().equals("admin")) {
		    	Admin admin = new Admin();
		    	admin.setUserName(userDto.getUserName());
		    	admin.setPassword(bcryptEncoder.encode(userDto.getPassword()));
		    	admin.setUserType(userDto.getUserType());
		    	admin.setAdminName(userDto.getName());
		    	admin.setAdminAge(userDto.getUserAge());
		    	admin.setAdminContact(userDto.getUserPhoneNumber());
		    	admin.setAdminEmailId(userDto.getEmailId());
		    	return ResponseEntity.ok(adminService.addAdminService(admin));
		    }
		    else {
		    	throw new Exception("User could not be created");
		    }
			
		}
	@PostMapping(value="/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest ) throws Exception{
		authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());

		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUserName());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
