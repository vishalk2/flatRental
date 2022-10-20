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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.config.JwtTokenUtil;
import com.cg.flatRental.entity.LandLord;
import com.cg.flatRental.repository.ILandLordRepository;
import com.cg.flatRental.secure.JwtRequest;
import com.cg.flatRental.secure.UserDto;
import com.cg.flatRental.service.ILandLordService;
import com.cg.flatRental.service.UserService;
import com.cg.flatRental.secure.JwtResponse;

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
		    
		    return null;
			
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
