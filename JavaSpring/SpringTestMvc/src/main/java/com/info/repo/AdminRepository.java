package com.info.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
//	Admin findByEmailAndPassword(String email, String password); //this is also right but to handle null pointer exception we will use Optional<T>

	Optional<Admin> findByEmailAndPassword(String email, String password);
}
