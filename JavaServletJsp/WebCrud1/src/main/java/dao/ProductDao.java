package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utility.DatabaseConnection;

public class ProductDao {
	public static boolean saveProduct(Product product) {
		try (Connection con = DatabaseConnection.getConnection()) {
			String sql = "insert into product (title,price,brand) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, product.getTitle());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getBrand());

			int x = ps.executeUpdate();
			if (x != 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		
		try (Connection con = DatabaseConnection.getConnection()) {
			String sql = "select * from product";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setPrice(rs.getInt("price"));
				p.setBrand(rs.getString("brand"));
				
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean deleteProduct(int id) {
		try (Connection con = DatabaseConnection.getConnection()) {
			String sql = "delete from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			int x = ps.executeUpdate();
			if (x != 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean editProduct(Product p) {
		try (Connection con = DatabaseConnection.getConnection()) {
			String sql = "update product set title = ?, price = ?, brand = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, p.getTitle());
			ps.setInt(2, p.getPrice());
			ps.setString(3, p.getBrand());
			ps.setInt(4, p.getId());

			int x = ps.executeUpdate();
			if (x != 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
