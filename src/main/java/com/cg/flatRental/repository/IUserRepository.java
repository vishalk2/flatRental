package com.cg.flatRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flatRental.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	// find user by user name and password
	public User findByUserNameAndPassword(String userName, String password);
	
	// find all users by user type
	public List<User> findByUserType(String userType);
	
	// update user password
	@Query("update User u set u.password = :pwd where u.userId= :uid")
	@Modifying
	public int updateUserPassword(@Param("uid") int userId, @Param("pwd") String newPassword);
}
