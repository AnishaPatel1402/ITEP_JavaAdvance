package com.info.SpringAnnotationConfig.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("1234")
	private int id;
	
	@Value("Neha Malviya")
	private String name;
	
	@Value("Java Depart")
	private String depart;
	
	@Value("100000")
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		String str = this.id+" "+ this.name + " " + this.depart +" " + this.salary;
		return str;
	}
	
}
