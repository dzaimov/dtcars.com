package com.dtcars.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dtcars.ads.Ad;
import com.dtcars.ads.MotorVehicleAd;
import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;
import com.dtcars.repository.JDBCRepository;
import com.dtcars.service.PhotoService;

/**
 * Servlet implementation class PublishServlet
 */
@WebServlet("/PublishServlet")
public class PublishServlet extends HttpServlet {
	
	private static final int NUMBER_OF_TECH_FEATURES = 4;
	private static final long serialVersionUID = 1L;
	private JDBCRepository repo = new JDBCRepository();
	private PhotoService photoService = new PhotoService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		 HttpSession session = request.getSession();
		
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String category = request.getParameter("category");
		String typeOfEngineByFuel = request.getParameter("engine_by_fuel");
		int engineCapacity = Integer.parseInt(request.getParameter("engine_capacity"));
		int power = Integer.parseInt(request.getParameter("power"));
		String transmission = request.getParameter("gearbox");
		int yearOfManufacture = Integer.parseInt(request.getParameter("year"));
		int mileage =Integer.parseInt(request.getParameter("mileage"));
		int price = Integer.parseInt(request.getParameter("price"));
		String color = request.getParameter("color");
		String abs = request.getParameter("abs");
		String esp = request.getParameter("esp");
		String airbag = request.getParameter("airbag");
		String xenon = request.getParameter("xenon");
		String additionalInfo = request.getParameter("additionalInfo");
		String photoUrl = request.getParameter("hid");
		
		Photo photo = photoService.createFromBase64WithHeader(photoUrl);
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		Set<String> techFeatures = new HashSet<>();
		techFeatures.add(abs);
		techFeatures.add(esp);
		techFeatures.add(airbag);
		techFeatures.add(xenon);
		
		Set<Photo> pics = new HashSet<>();
		pics.add(photo);
		MotorVehicleAd ad = null;
		try {
			ad = new MotorVehicleAd(brand, model, price, color, techFeatures, 
					pics, additionalInfo, userId, yearOfManufacture, typeOfEngineByFuel, 
					engineCapacity, power, transmission, category, mileage);
		} catch (AdException e) {
			e.printStackTrace();
		}
		
		this.repo.addMotorVehicleAd(ad);
		
		request.setAttribute("isPublished", true);
		request.getRequestDispatcher("/publish.html").forward(request, response);
		
	}

}
