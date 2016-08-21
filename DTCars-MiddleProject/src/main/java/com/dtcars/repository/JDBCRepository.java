package com.dtcars.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.users.PrivateUser;
import com.dtcars.users.User;

public class JDBCRepository implements IRepository {
	private Connection connection;

	public JDBCRepository() {
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream("src/database.properties");
			properties.load(fis);
			String user = properties.getProperty("db.user");
			String pass = properties.getProperty("db.pass");
			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into users " + 
					"values (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getName());
			stmt.setString(5, user.getPhoneNumber());
			stmt.setString(6, user.getLocation());
			stmt.setString(7, user.getClass().getSimpleName());

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
		// TODO Auto-generated method stub
		return null;
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
