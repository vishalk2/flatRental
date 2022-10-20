package com.cg.flatRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.flatRental.entity.Tenant;


public interface ITenantRepository extends JpaRepository<Tenant, Long> {
	
	// find tenant by user name and password
	public Tenant findByUserNameAndPassword(String userName, String password);
	
	// find tenant by user name
	public Tenant findByUserName(String userName);
	
	// update tenant age
	@Query("update Tenant t set t.tenantAge = :age where t.userId = :uid")
	@Modifying
	public int updateTenantAge(@Param("uid") long userId, @Param("age") int newAge);
	
	// update tenant phone number
	@Query("update Tenant t set t.tenantPhoneNumber = :phno where t.userId = :uid")
	@Modifying
	public int updateTenantPhoneNumber(@Param("uid") long userId, @Param("phno") long newPhoneNumber);
	
	// update tenant email
	@Query("update Tenant t set t.emailId = :email where t.userId = :uid")
	@Modifying
	public int updateTenantEmail(@Param("uid") long userId, @Param("email") String newEmail);
}
