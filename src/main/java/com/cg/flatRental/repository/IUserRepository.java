package com.cg.flatRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flatRental.secure.User;


public interface IUserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName);
	
}
