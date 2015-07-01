package com.java.librarymanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Krishna
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/**
		 * Getting parameter Login form when user submits the form from request to LoginController
		 */
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");

		//validation for Admin.
		if (uname.equals("krishna") && pwd.equals("passw0rd")) {
			 HttpSession session=request.getSession();  
		        session.setAttribute("username",uname);  
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/home.jsp");
			rd.forward(request, response);
		} else {
			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
			rd.include(request, response);
		}

	}

}
