package com.info.SpringTestDI2.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
	private int id;
	private String name;
	
	private List<String> addressList;
	private Set<String> mobileList;
	private Map<String, String> projectList;
	
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
	public List<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	public Set<String> getMobileList() {
		return mobileList;
	}
	public void setMobileList(Set<String> mobileList) {
		this.mobileList = mobileList;
	}
	public Map<String, String> getProjectList() {
		return projectList;
	}
	public void setProjectList(Map<String, String> projectList) {
		this.projectList = projectList;
	}
	
	public void display() {
		System.out.println("Employee Basic Details : "+id+" "+name);
		System.out.println("Address Details : "+addressList.toString());
		System.out.println("Phone List : "+mobileList.toString());
		System.out.println("Project List : "+projectList.toString());
	}
	
}
