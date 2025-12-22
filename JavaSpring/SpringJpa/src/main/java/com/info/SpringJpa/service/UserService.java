package com.info.SpringJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.SpringJpa.entity.User;
import com.info.SpringJpa.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Transactional
	public boolean saveUser(User u) {
		User user = repo.save(u);
		if(user != null) return true;
		return false;
	}
	
}
