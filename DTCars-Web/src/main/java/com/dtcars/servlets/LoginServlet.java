package com.dtcars.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dtcars.repository.JDBCRepository;
import com.dtcars.users.Admin;
import com.dtcars.users.PrivateUser;
import com.dtcars.users.User;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JDBCRepository repo = new JDBCRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		  response.setContentType("text/html");
          request.setCharacterEncoding("UTF-8");
          
          HttpSession session = request.getSession();
          
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println("Login user");
		
		User user = getUser(email, password);
		
		if(user != null){
			session.setAttribute("userId", user.getId());
		}
		
		if (user instanceof PrivateUser) {
			PrivateUser prUser = (PrivateUser) user;
		
			request.setAttribute("user", prUser);
		} else {
			
			Admin admin = (Admin) user;
			
			request.setAttribute("user", admin);
		}

		request.getRequestDispatcher("/indexwithlogin.jsp").forward(request, response);
	}

	private User getUser(String email, String password) {
		return this.repo.getUser(email, password);
	}
}
