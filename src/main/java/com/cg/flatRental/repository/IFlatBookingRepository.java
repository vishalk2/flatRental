package com.cg.flatRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flatRental.entity.FlatBooking;

@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking, Integer> {
	// CRUD operations
}
