package com.cg.flatRental.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cg.flatRental.repository.IUserRepository;
import com.cg.flatRental.secure.User;
import com.cg.flatRental.secure.UserDto;

@Component
public class UserService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(user.getUserType()));
		System.out.println("Roles : "+roles);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				roles);
	}
	
	public User save(com.cg.flatRental.secure.UserDto user) {
		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUserType(user.getUserType());
		return userRepository.save(newUser);
	}

}
