package com.coforge.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.registration.model.User;
import com.coforge.registration.repo.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
	   return  userRepo.findByEmailId(email);
	}
	
	public User findByEmailIdAndPassword(String email,String password) {
		   return  userRepo.findByEmailIdAndPassword(email, password);
		}


}
