package com.cg.secure.repository;
import org.springframework.data.repository.CrudRepository;

import com.cg.secure.model.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}