package com.dtcars.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dtcars.repository.JDBCRepository;
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

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (getUser(email, password) instanceof PrivateUser) {
			PrivateUser user = (PrivateUser) getUser(email, password);

			request.setAttribute("name", user.getName());
		} else {
			request.setAttribute("name", null);
		}

		request.getRequestDispatcher("indexwithlogin.jsp").forward(request, response);
	}

	private User getUser(String email, String password) {
		for (User user : this.repo.getUsers()) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
