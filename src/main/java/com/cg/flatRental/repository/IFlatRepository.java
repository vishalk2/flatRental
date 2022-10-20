package com.cg.flatRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flatRental.entity.Flat;

@Repository
public interface IFlatRepository extends JpaRepository<Flat, Integer> {
	
	// update flat approval
	@Query("update Flat f set f.approved = :app where f.flatId = :fid")
	@Modifying
	public int updateFlatApproval(@Param("fid") int flatId, @Param("app") boolean approved);
	
	// update flat availability
	@Query("update Flat f set f.available = :av where f.flatId = :fid and f.approved = true")
	@Modifying
	public int updateFlatAvailability(@Param("fid") int flatId, @Param("av") boolean available);
	
	// find flats by their rental cost
	@Query("select f from Flat f where f.available = true and f.rentalCost <= :a")
	public List<Flat> findFlatsByRentalCost(@Param("a") double rentalCost);
	
	// find flats by their type
	@Query("select f from Flat f where f.available = true and f.flatType = :a")
	public List<Flat> findFlatsByFlatType(@Param("a") String flatType);
	
	// find flats by area name
	@Query("select f from Flat f where f.available = true and f.flatAddress.area = :a")
	public List<Flat> findFlatsByArea(@Param("a") String area);
	
	// find flats by city
	@Query("select f from Flat f where f.available = true and f.flatAddress.city = :c")
	public List<Flat> findFlatsByCity(@Param("c") String city);
	
	// find flats by state
	@Query("select f from Flat f where f.available = true and f.flatAddress.state = :s")
	public List<Flat> findFlatsByState(@Param("s") String state);
	
	// find flats by country
	@Query("select f from Flat f where f.available = true and f.flatAddress.country = :c")
	public List<Flat> findFlatsByCountry(@Param("c") String country);
	
	// find flats by pincode
	@Query("select f from Flat f where f.available = true and f.flatAddress.pincode = :p")
	public List<Flat> findFlatsByPincode(@Param("p") int pincode);
	
	// find flats with garden
	@Query("select f from Flat f where f.available = true and f.flatAmenities.garden = :g")
	public List<Flat> findFlatsFlatsWithGarden(@Param("g") boolean garden);
	
	// find flats with swimmingPool
	@Query("select f from Flat f where f.available = true and f.flatAmenities.swimmingPool = :sp")
	public List<Flat> findFlatsFlatsWithSwimmingPool(@Param("sp") boolean swimmingPool);
	
	// find flats with carParking
	@Query("select f from Flat f where f.available = true and f.flatAmenities.carParking = :cp")
	public List<Flat> findFlatsWithCarparking(@Param("cp") boolean carParking);
	
	// find flats by their facing
	@Query("select f from Flat f where f.available = true and f.flatAmenities.houseFacing = :hf")
	public List<Flat> findFlatsByFacing(@Param("hf") String houseFacing);

	// find flats by their area (sq feet)
	@Query("select f from Flat f where f.available = true and f.flatAmenities.squareFeet = :sf")
	public List<Flat> findFlatsBySquareFeet(@Param("sf") double squareFeet);
}
