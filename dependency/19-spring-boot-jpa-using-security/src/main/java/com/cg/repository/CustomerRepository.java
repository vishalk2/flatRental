package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Customer;
@Repository

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	@Query("update Customer c set c.email =:email  where c.custId=:cid")
	@Modifying
	int upadteEmail(@Param("cid") int cid, @Param("email") String newEmail);
    
	List<Customer> findByCustomerType(String ctype);
//	@Transactional
//	@Query("update Customer c1 set c1.address =:c.address where c1.custId=:custId")
//	@Modifying
//	int updateCustomer(int custId,@RequestBody Customer c);
}
