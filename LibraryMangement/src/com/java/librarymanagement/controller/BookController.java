package com.java.librarymanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author krishna 
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getParameter("action");
		String forward = "/WEB-INF/views/book/listBook.jsp";
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		HttpSession session=request.getSession(false);  
        if(session!=null){  
         }  
        else{  
            
            request.getRequestDispatcher("adminLogin.jsp").include(request, response);  
        }  
         
	}

}
