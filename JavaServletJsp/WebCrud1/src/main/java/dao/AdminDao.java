package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;
import model.Product;
import utility.DatabaseConnection;

public class AdminDao {

	public static boolean checkAdmin(Admin admin) {
		try(Connection con = DatabaseConnection.getConnection()){
			String sql = "select * from admininfo where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getEmail());
			ps.setString(2, admin.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}



}
