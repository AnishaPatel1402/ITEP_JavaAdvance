package com.info.MeetingMapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {  //inverse side -> mapped by 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private int age;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private AadharCard personAadhar;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AadharCard getPersonAadhar() {
		return personAadhar;
	}

	public void setPersonAadhar(AadharCard personAadhar) {
		this.personAadhar = personAadhar;
	}
	
	
}
