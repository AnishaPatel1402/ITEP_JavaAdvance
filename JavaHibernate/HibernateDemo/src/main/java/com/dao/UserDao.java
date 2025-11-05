package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.User;
import com.utility.DatabaseConnection;

public class UserDao {
	public static boolean addUser(User u) {
		Connection conn = DatabaseConnection.getDBConnection();
		try {
			String sql = "insert into user (name, address, password)values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getPassword());
			int x = ps.executeUpdate();
			if(x!=0) return true;
			else return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
