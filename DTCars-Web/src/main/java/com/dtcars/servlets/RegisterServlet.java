package com.dtcars.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidLocationException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.repository.JDBCRepository;
import com.dtcars.users.PrivateUser;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private JDBCRepository repo = new JDBCRepository();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("Register new user");
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String location = request.getParameter("location");
		
		try {
			PrivateUser user = new PrivateUser(email, password, name, phone, location);
			this.repo.addUser(user);
			request.setAttribute("user", user);
		} catch (InvalidEmailException | InvalidPasswordException | InvalidNameException | InvalidPhoneNumberException
				| InvalidLocationException e) {
			e.printStackTrace();
			request.setAttribute("user", null);
		}finally {
			request.getRequestDispatcher("indexwithregistration.jsp").forward(request, response);
		}
	}

}
