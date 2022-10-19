package com.cg.flatRental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.flatRental.entity.User;
import com.cg.flatRental.exceptions.UserNotFoundException;
import com.cg.flatRental.repository.IUserRepository;

@Component
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User addUserService(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public User deleteUserService(int userId) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			userRepository.deleteById(userId);
			return user;
		}
		else {
			throw new UserNotFoundException("User details not found!");
		}
	}

	@Override
	public User updateUserService(int userId, User user) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			userRepository.save(user);
			return optionalUser.get();
		}
		else {
			throw new UserNotFoundException("User details not found!");
		}
	}

	@Override
	public User viewUserService(int userId) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			throw new UserNotFoundException("User details not found!");
		}
	}

	@Override
	public List<User> viewAllUsersService() {
		List<User> userList = new ArrayList<>();
		Iterable<User> users = userRepository.findAll();
		users.forEach(u->userList.add(u));
		return userList;
	}

	@Override
	public boolean isValidUserService(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password)!=null?true :false;
	}

	@Override
	public User updateUserPasswordService(int userId, String newPassword) throws UserNotFoundException {
		int u = userRepository.updateUserPassword(userId, newPassword);
		if(u>0) {
			return viewUserService(userId);
		}
		else {
			throw new UserNotFoundException("User details not found!");
		}
	}
}
