package com.info.ecommerce.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.info.ecommerce.entity.User;
import com.info.ecommerce.exception.UnauthorizedException;
import com.info.ecommerce.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private UserRepository repo;
	private PasswordEncoder passwordEncoder;
	public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}
	
	
		@Transactional
	   public User registerUser(User user) {
		  String encodedPassword =  passwordEncoder.encode(user.getPassword()); 
		  user.setPassword(encodedPassword);
		  return repo.save(user);
	   }
	   
	   public User authenticateUser(User user) {
		  User dbUser = repo.findByEmail(user.getEmail()).orElseThrow(()->new UnauthorizedException("Unauthorized | Invalid Email Id"));
	      if(!passwordEncoder.matches(user.getPassword(), dbUser.getPassword()))
	    	  throw new UnauthorizedException("Unauthorized | Invalid password");
	      return dbUser; 
	   }
	
}
