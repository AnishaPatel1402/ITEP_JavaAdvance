package com.info.TestJPA.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentCourseKey {

	private int studentId;
	private int courseId;

	
	public int hashcode() {
		return Objects.hash(studentId, courseId);
	}

		@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StudentCourseKey))
			return false;

		StudentCourseKey sc = (StudentCourseKey) obj;
		return this.studentId == sc.studentId && this.courseId == sc.courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
