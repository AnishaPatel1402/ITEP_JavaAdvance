package com.info.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.entity.Admin;
import com.info.repo.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repo;
	
	public Admin registerAdmin(Admin a) {
		return repo.save(a);
	}
	
	public Admin loginAdmin(Admin a) {
//		Optional<Admin> opAdmin = repo.findByEmailAndPassword(a.getEmail(),a.getPassword());
//		if(opAdmin.isPresent()) return opAdmin.get();
//		else return null;
		
		//short hand of above
		return repo.findByEmailAndPassword(a.getEmail(), a.getPassword()).orElse(null);
		
	}
}
