package com.info.SpringJdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.info.SpringJdbc.entity.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setId(rs.getInt(1));
		u.setName(rs.getString(2));
		u.setAge(rs.getInt(3));
		return u;
	}


}
