package com.cg.flatRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flatRental.entity.LandLord;

@Repository
public interface ILandLordRepository extends JpaRepository<LandLord, Long> {
	
	// find landlord by user name and password
	public LandLord findByUserNameAndPassword(String userName, String password);
	
	// find landlord by user name
	public LandLord findByUserName(String userName);
	
	// update landlord age
	@Query("update LandLord l set l.landLordAge = :age where l.userId = :uid")
	@Modifying
	public int updateLandLordAge(@Param("uid") long userId, @Param("age") int newAge);
	
	// update landlord phone number
	@Query("update LandLord l set l.landLordPhoneNumber = :phno where l.userId = :uid")
	@Modifying
	public int updateLandLordPhoneNumber(@Param("uid") long userId, @Param("phno") long newPhoneNumber);
	
	// update landlord email
	@Query("update LandLord l set l.landLordEmailId = :email where l.userId = :uid")
	@Modifying
	public int updateLandLordEmail(@Param("uid") long userId, @Param("email") String newEmail);
}
