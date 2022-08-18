package com.coforge.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.registration.model.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmailId(String email);
	
	public User findByEmailIdAndPassword(String email,String password);
	

}
