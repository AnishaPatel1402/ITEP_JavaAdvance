package com.info.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.ecommerce.dto.UserDto;
import com.info.ecommerce.entity.User;
import com.info.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserCotroller {
	
	private UserService service;
	public UserCotroller(UserService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody User user){
		User dbUser = service.registerUser(user);
		UserDto u = new UserDto();
		u.setId(dbUser.getId());
		u.setEmail(dbUser.getEmail());
		u.setUsername(dbUser.getUsername());
		return ResponseEntity.ok().body(u);
	}

	
	@PostMapping("/login")
	public ResponseEntity<UserDto> loginUser(@RequestBody User user){
		User dbUser = service.authenticateUser(user);
		UserDto u = new UserDto();
		u.setId(dbUser.getId());
		u.setEmail(dbUser.getEmail());
		u.setUsername(dbUser.getUsername());
		return ResponseEntity.ok().body(u);
	}
}
