package com.cg.flatRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flatRental.entity.BookingRequest;

@Repository
public interface IBookingRequestRepository extends JpaRepository<BookingRequest, Integer>{
	// CRUD operations
	
	@Query("select b.flat.flatId from BookingRequest b where b.reqId = :req")
	public int getFlatIdByBookingRequestId(@Param("req") int reqId);
	
	// update booking request approval
	@Query("update BookingRequest b set b.approved = :app where b.reqId = :req")
	@Modifying
	public int updateBookingRequestApproval(@Param("req") int reqId, @Param("app") boolean approval);
	
	// all requests that are approved
	@Query("select b from BookingRequest b where b.approved = true")
	public List<BookingRequest> getAllApprovedBookingRequests();
	
	// all requests for a landlord
	@Query("select b from BookingRequest b where b.flat.flatLandLord.userName = :uname")
	public List<BookingRequest> getAllBookingRequestsByLandLordUserName(@Param("uname") String userName);
	
	// all requests for a landlord
	@Query("select b from BookingRequest b where b.tenant.userName = :uname")
	public List<BookingRequest> getAllBookingRequestsByTenantUserName(@Param("uname") String userName);
}

