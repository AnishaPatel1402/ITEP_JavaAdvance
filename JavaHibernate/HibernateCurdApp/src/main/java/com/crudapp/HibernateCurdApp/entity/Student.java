package com.crudapp.HibernateCurdApp.entity;

import com.crudapp.HibernateCurdApp.utility.DataConvertor;
import com.crudapp.HibernateCurdApp.utility.HashPasswordUtill;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity  
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	
	@Column(name = "student_name", nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 100)
	@Convert(converter = DataConvertor.class)	//this is to encrypt the email data whose code is written in DataCovertor class
	private String email;
	
	@Column(nullable = false, length = 200)
	private String password;
	
	@PrePersist
	@PreUpdate
	public void hashPasswordBeforeSave() {
		if(password != null && !password.startsWith("$2a$")) 
			password = HashPasswordUtill.hashPassword(password);
	}
	
	
	public Student() {}

	public Student(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Student(int rollno, String name, String email, String password) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
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
	
}
