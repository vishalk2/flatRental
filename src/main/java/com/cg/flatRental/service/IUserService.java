package com.cg.flatRental.service;

import java.util.List;

import com.cg.flatRental.entity.User;
import com.cg.flatRental.exceptions.UserNotFoundException;

public interface IUserService {
	
	public User addUserService(User user);
	
	public User deleteUserService(int userId) throws UserNotFoundException;
	
	public User updateUserService(int userId, User user) throws UserNotFoundException;
	
	public User viewUserService(int userId) throws UserNotFoundException;
	
	public List<User> viewAllUsersService();
	
	public boolean isValidUserService(String userName, String password);
	
	public User updateUserPasswordService(int userId, String newPassword) throws UserNotFoundException;
}
