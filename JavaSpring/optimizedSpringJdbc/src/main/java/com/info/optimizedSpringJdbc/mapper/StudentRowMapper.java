package com.info.optimizedSpringJdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.info.optimizedSpringJdbc.entity.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setRoll(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setCourse(rs.getString(3));
		return s;
	}

}
