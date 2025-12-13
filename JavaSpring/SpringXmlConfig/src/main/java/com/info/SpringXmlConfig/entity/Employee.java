package com.info.SpringXmlConfig.entity;

public class Employee {
	
	private int id;
	private String name;
	private String depart;
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
