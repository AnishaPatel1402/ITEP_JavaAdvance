package com.model;

public class User {
	private int id;
	private String name;
	private String address;
	private String password;
	
	public User() {}
	public User(String name, String address, String password) {
		this.name = name;
		this.address = address;
		this.password = password;
	}
	
	public User(int id, String name, String address, String password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
	}
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
