package com.TestMapping.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	
	@ManyToMany(mappedBy = "studentList", cascade = CascadeType.PERSIST)
	private List<Course> courseList = new ArrayList<Course>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Course> getCourses() {
		return courseList;
	}

	public void setCourses(List<Course> courses) {
		this.courseList = courses;
	}
	
	
	
}
