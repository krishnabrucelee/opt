package com.java.librarymanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.librarymanagement.service.MemberService;
import com.java.librarymanagement.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/memberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		/**
		 * Getting parameter Admin Dashboard form when admin submits the Memberdetails from request to MemberController
		 */
		 String member = request.getParameter("memberDetails");
		 
		 MemberService memberService = new MemberServiceImpl();
	}

	

}
