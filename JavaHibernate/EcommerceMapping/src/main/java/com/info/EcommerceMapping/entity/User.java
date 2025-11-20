package com.info.EcommerceMapping.entity;

import javax.xml.crypto.Data;

import com.info.EcommerceMapping.utility.DataConvertorUtil;
import com.info.EcommerceMapping.utility.PasswordHashUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	
	private String password;
	
	@Convert(converter = DataConvertorUtil.class)
	private String aadharno;
	
	@OneToOne(mappedBy = "user")
	private Cart userCart;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public Cart getUserCart() {
		return userCart;
	}

	public void setUserCart(Cart userCart) {
		this.userCart = userCart;
	}
	
	
	@PrePersist
	@PreUpdate
	public void hashPasswordBeforeSave() {
		if(password!=null && !password.startsWith("$2a$")) password = PasswordHashUtil.hashPassword(password);
	}
	
	
}
