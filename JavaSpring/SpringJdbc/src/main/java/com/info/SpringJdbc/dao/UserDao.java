package com.info.SpringJdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.info.SpringJdbc.entity.User;
import com.info.SpringJdbc.mapper.UserRowMapper;

public class UserDao {
	
	@Autowired
	private JdbcTemplate template;  //field injection
	
	public boolean saveUser(User u) {
		String sql = "INSERT INTO users VALUES(?,?,?)";
		return template.update(sql, u.getId(), u.getName(), u.getAge()) > 0;
	}
	
	
	public boolean updateUser(User u) {
		String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
		return template.update(sql, u.getName(), u.getAge(), u.getId()) > 0;
	}
	
	public boolean deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		return template.update(sql, id) > 0;
	}


	public List<User> getList() {
		List<User> list = template.query("SELECT * FROM users", new UserRowMapper());
		return list;
	}


	public User getUser(int id) {
		User u = template.queryForObject("SELECT * FROM users WHERE id = ?", new Object[] {id}, new UserRowMapper());
		return u;
	}

}
