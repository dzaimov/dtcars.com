package com.dtcars.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidLocationException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.users.Admin;
import com.dtcars.users.PrivateUser;
import com.dtcars.users.User;

public class JDBCRepository implements IRepository {
	private Connection connection;

	public JDBCRepository() {
		try {
			String user = "root";
			String pass = "root";
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/dTcars?autoReconnect=true&useSSL=false";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into users(email,password,name,phoneNumber,location, typeOfUser) "
				+ "values ( ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(5, user.getLocation());
			stmt.setString(6, user.getClass().getSimpleName());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<User> getUsers() {
		String sql = "select * from users";
		Set<User> users = new HashSet<User>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String location = rs.getString("location");
				String userType = rs.getString("typeOfUser");

				User user = null;

				if (userType.equalsIgnoreCase("privateUser")) {
					user = new PrivateUser(id, email, password, name, phoneNumber, location);
				}
				if (userType.equalsIgnoreCase("admin")) {
					user = new Admin(id, email, password);
				}
				users.add(user);
			}

		} catch (SQLException | InvalidEmailException | InvalidPasswordException | InvalidNameException
				| InvalidPhoneNumberException | InvalidLocationException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void addAd(Ad ad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAd(int adId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Ad> getAdss() {
		// TODO Auto-generated method stub
		return null;
	}

}
