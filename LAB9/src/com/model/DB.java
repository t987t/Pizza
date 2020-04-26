package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.beans.User;

public class DB {
	// Step 1 - create variables
	private String username = "root";
	private String password = "";
	private String dbName = "lab9";
	private String url = "jdbc:mysql://localhost:3306/" + dbName;
	private String driver = "com.mysql.jdbc.Driver";
	private Connection con;

	private void dbConnect() {
		// Step 2 - Load the Driver
		try {
			Class.forName(driver); // Register the Driver
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getUsers() throws SQLException {
		String sql = "select * from user";
		PreparedStatement stmt = con.prepareStatement(sql);
	}

	public void addUser(User user) throws SQLException {
		dbConnect();
		String sql = "insert into users(username,password,name)values(?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getAddress());
		stmt.setString(3, user.getPhone_number());
		stmt.executeUpdate();
		dbClose();
	}

	public boolean checkUser(String username, String password) throws SQLException {

		dbConnect();
		int count = 0;
		String sql = "SELECT * FROM users WHERE username=? AND password =?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rst = stmt.executeQuery();
		while (rst.next()) {
			count = 1;
		}
		dbClose();
		if (count == 0)
			return false;
		return true;
	}

}