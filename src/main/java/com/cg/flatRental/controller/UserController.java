package com.cg.flatRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatRental.dto.UserPasswordUpdateDto;
import com.cg.flatRental.entity.User;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<User> addUser(@RequestBody @Valid User user){
		return new ResponseEntity<>(userService.addUserService(user), HttpStatus.OK);
	}
	
	@PutMapping(value="/{userId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<User> updateUser(@PathVariable int userId, @Valid User user) throws UserNotFoundException{
		return new ResponseEntity<>(userService.updateUserService(userId, user), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{userId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<User> removeUser(@PathVariable int userId) throws UserNotFoundException{
		return new ResponseEntity<>(userService.deleteUserService(userId), HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<User> viewUser(@PathVariable int userId) throws UserNotFoundException{
		return new ResponseEntity<>(userService.viewUserService(userId), HttpStatus.OK);
	}
	
	@GetMapping(produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<List<User>> viewAllUser(){
		return new ResponseEntity<>(userService.viewAllUsersService(), HttpStatus.OK);
	}
	
	@PutMapping(value="/updation/password",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<User> updateUserPassword(@RequestBody UserPasswordUpdateDto userPasswordUpdateDto) throws UserNotFoundException{
		return new ResponseEntity<>(userService.updateUserPasswordService(userPasswordUpdateDto.getUserId(), userPasswordUpdateDto.getPassword()), HttpStatus.OK);
	}
	
	@GetMapping(value="/valid/{username}/{password}",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public ResponseEntity<Boolean> isValidUser(@PathVariable String username, @PathVariable String password){
		return new ResponseEntity<>(userService.isValidUserService(username, password),HttpStatus.OK);
	}
}
