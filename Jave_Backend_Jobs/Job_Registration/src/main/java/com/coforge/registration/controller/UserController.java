package com.coforge.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.registration.model.User;
import com.coforge.registration.service.UserService;

@RestController
@RequestMapping("/api/v2")
public class UserController {
	

	@Autowired
	private UserService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempEmailId=user.getEmailId();
	    if((tempEmailId!=null) && (!"".equals(tempEmailId))) {
	    	User fetchUserByEmailId = service.fetchUserByEmailId(tempEmailId);
	        if(fetchUserByEmailId!=null) {
	        	throw new Exception("User with "+tempEmailId+" is allready exists");
	        }
	    }
		
		User saveUser = service.saveUser(user);
		return saveUser;
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPassword=user.getPassword();
		User findByEmailIdAndPassword=null;
		
		if(tempEmailId!=null && tempPassword!=null) {
			findByEmailIdAndPassword = service.findByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		
		if(findByEmailIdAndPassword==null) {
			throw new Exception("Bad credentials");
		}
		return findByEmailIdAndPassword;
		
	}
	
	
}
