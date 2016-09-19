package com.dtcars.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.ads.BikeAd;
import com.dtcars.ads.MotorVehicleAd;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidLocationException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.photo.Photo;
import com.dtcars.users.Admin;
import com.dtcars.users.PrivateUser;
import com.dtcars.users.User;

public class JDBCRepository implements IRepository {
	private Connection connection;

	public JDBCRepository() {
		try {
			String user = "root";
			String pass = "06011028";
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/dTcars?autoReconnect=true&useSSL=false";
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

			
			System.out.println("Save user");
			
			stmt.executeUpdate();
		//	stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String email, String password) {
		String sql = "select * from users where email = ? and password = ?";

		User user = null;
		
		System.out.println("Get user");
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String location = rs.getString("location");
				String userType = rs.getString("typeOfUser");

				if (userType.equalsIgnoreCase("privateUser")) {
					user = new PrivateUser(id, email, password, name, phoneNumber, location);
				}
				if (userType.equalsIgnoreCase("admin")) {
					user = new Admin(id, email, password);
				}
			}

		} catch (SQLException | InvalidEmailException | InvalidPasswordException | InvalidNameException
				| InvalidPhoneNumberException | InvalidLocationException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addMotorVehicleAd(MotorVehicleAd ad) {
		String sql = "insert into ads values ( null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			
			
			stmt.setString(1, ad.getBrand());
			stmt.setString(2, ad.getModel());
			stmt.setString(3, ad.getCategory());
			stmt.setString(4, ad.getTypeOfEngineByFuel());
			stmt.setInt(5, ad.getEngineCapacity());
			stmt.setInt(6, ad.getPower());
			stmt.setString(7, ad.getTransmission());
			stmt.setInt(8, ad.getYearOfManufacture());
			stmt.setInt(9, ad.getMileage());
			stmt.setInt(10, ad.getPrice());
			stmt.setString(11, ad.getColor());
			LocalDateTime date = ad.getDatePublished().withNano(0).withSecond(0);
			
			stmt.setString(12, date.toString());
			
			StringBuilder techFeatures = new StringBuilder();
			for (String feature : ad.getTechFeatures()) {
				if(feature != null){
					techFeatures.append(feature + ";");
				}
			}
			
			stmt.setString(13, techFeatures.toString());
			stmt.setString(14, ad.getAdditionalInfo());
			
			StringBuilder photos = new StringBuilder();
			for (Photo pic : ad.getPhotos()) {
				photos.append(pic.getPath());
			}
			
			stmt.setString(15, photos.toString());
			stmt.setInt(16, ad.getUserId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addBikeAd(BikeAd ad) {
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

	@Override
	public void addPhoto(Photo photo) {
		String sql = "insert into photos(path) "
				+ "values ( ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, photo.getPath());
		
			System.out.println("Save photo");
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public int getAdsCount() {
		String sql = "select count(*) from ads;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
}
