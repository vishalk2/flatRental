package com.cg.flatRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flatRental.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
	// CRUD Operations
}
