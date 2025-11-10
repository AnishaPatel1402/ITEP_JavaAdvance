package com.StudentHQL.StudentHQL.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="studentHql")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
//	@Temporal(TemporalType.DATE) → stores only the date (e.g., 2025-11-10)
//
//	@Temporal(TemporalType.TIME) → stores only the time (e.g., 10:30:15)
//
//	@Temporal(TemporalType.TIMESTAMP) → stores date + time (e.g., 2025-11-10 10:30:15)
	
	public StudentEntity() {
	}
	
	
	
	public StudentEntity(int rollno, String name, String email, Date date) {
		
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.date = date;
	}

	


	public StudentEntity(String name, String email, Date date) {
		
		this.name = name;
		this.email = email;
		this.date = date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
