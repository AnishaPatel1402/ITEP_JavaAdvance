package com.info.optimizedSpringJdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.info.optimizedSpringJdbc.entity.Student;
import com.info.optimizedSpringJdbc.mapper.StudentRowMapper;

public class StudentDao {
	private JdbcTemplate template;
	
	public StudentDao(JdbcTemplate template) {
		this.template = template;
	}
	
	public boolean saveStudent(Student s) {
		String sql = "Insert into students values(?,?,?)";
		return template.update(sql, s.getRoll(), s.getName(), s.getCourse()) > 0;
	}
	
	public boolean updateStudent(Student s) {
		String sql = "update students set name = ?, course = ? where roll = ?";
		return template.update(sql, s.getName(), s.getCourse(), s.getRoll()) > 0;
	}
	
	public boolean deleteStudent(int roll) {
		String sql = "delete from students where roll = ?";
		return template.update(sql, roll) > 0;
	}
	
	public List<Student> getList() {
		List<Student> list = template.query("SELECT * FROM students", new StudentRowMapper());
		return list;
	}
	
	public Student get(int roll) {
		return template.queryForObject("SELECT * FROM students where roll = ?" ,new Object[]{roll}, new StudentRowMapper());
	}
}
