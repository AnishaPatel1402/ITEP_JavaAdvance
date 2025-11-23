package com.info.TestJPA.entity;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class StudentCourse {
	
	@EmbeddedId
	private StudentCourseKey key; //composite key
	private String StudentName;
	private String courseName;
	
	
	
	
	public StudentCourseKey getKey() {
		return key;
	}
	public void setKey(StudentCourseKey key) {
		this.key = key;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
}
