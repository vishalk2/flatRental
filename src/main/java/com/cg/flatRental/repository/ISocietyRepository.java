package com.cg.flatRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.flatRental.entity.Society;

public interface ISocietyRepository extends JpaRepository<Society, Integer>{
	
	// update society approval
	@Query("update Society s set s.approved = :app where s.societyId = :sid")
	@Modifying
	public int updateSocietyApproval(@Param("sid") int societyId, @Param("app") boolean approved);
	
	// update society approval
	@Query("update Society s set s.societyName = :app where s.societyId = :sid")
	@Modifying
	public int updateSocietyName(@Param("sid") int societyId, @Param("app") String societyName);
	
	// update society address
	@Query("update Society s set s.societyAddress.area = :area, "
			+ "s.societyAddress.city = :city, s.societyAddress.state = :state, "
			+ "s.societyAddress.country = :country, "
			+ "s.societyAddress.pincode = :pin where s.societyId = :sid")
	@Modifying
	public int updateSocietyAddress(@Param("sid") int societyId, @Param("area") String area,
			@Param("city") String city, @Param("state") String state, 
			@Param("country") String country, @Param("pin") int pincode);
	
	// find societies by their name
	public List<Society> findBySocietyName(String societyName);
	
	// find societies by their area
	@Query("select s from Society s where s.societyAddress.area = :a")
	public List<Society> filterBySocietyArea(@Param("a") String area);
	
	// find societies by their city
	@Query("select s from Society s where s.societyAddress.city = :c")
	public List<Society> filterBySocietyCity(@Param("c") String city);
	
	// find societies by their state
	@Query("select s from Society s where s.societyAddress.state = :s")
	public List<Society> filterBySocietyState(@Param("s") String state);
	
	// find societies by their country
	@Query("select s from Society s where s.societyAddress.country = :c")
	public List<Society> filterBySocietyCountry(@Param("c") String country);
	
	// find societies by their pincode
	@Query("select s from Society s where s.societyAddress.pincode = :p")
	public List<Society> filterBySocietyPincode(@Param("p") int pincode);
}

