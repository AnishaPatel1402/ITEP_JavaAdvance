package com.TestMapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String passportNum;
	
	@OneToOne(fetch = FetchType.LAZY)  //by this user will be fetched lazily
	@JoinColumn(name = "user_ki_id")
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassportNum() {
		return passportNum;
	}
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
