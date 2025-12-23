package com.info.crudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.crudapi.entitty.Admin;
import com.info.crudapi.repo.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repo;
	public Admin validate(Admin admin) {
		Admin dbAdmin = repo.findByEmailAndPassword(admin.getEmail(), admin.getPassword()).orElse(null);
		return dbAdmin;
	}
}
