package com.java.librarymanagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.librarymanagement.model.dao.MemberDao;
import com.java.librarymanagement.model.entity.MemberEntity;
import com.java.librarymanagement.service.MemberService;
import com.java.librarymanagement.service.MemberServiceImpl;

/**
 * @author Krishna
 * Servlet implementation class ListMemberController
 */
@WebServlet("/ListMemberController")
public class ListMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String insert_editMember = "/WEB-INF/views/member/addMember.jsp";
	private static String listMember = "/WEB-INF/views/member/listMember.jsp";
	
	MemberEntity member = new MemberEntity();
	MemberService memberDetails = new MemberServiceImpl();
	MemberDao dao = new MemberDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListMemberController() {
		super();	
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";
		
		
		// Checks the request from the parameter
		if (action.equalsIgnoreCase("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));

			memberDetails.getMemberDetails(userId);

			// It forwards the response to listMember
			forward = listMember;
			request.setAttribute("users", dao.getAllMembers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = insert_editMember;

			int userId = Integer.parseInt(request.getParameter("userId"));
			
			MemberEntity member = dao.getUserById(userId);
			request.setAttribute("user", member);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = listMember;
			request.setAttribute("users", memberDetails.getAllMemberDetails());
		} else {
			forward = insert_editMember;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		member.setFirstName(request.getParameter("firstName"));
		member.setLastName(request.getParameter("lastName"));

		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
			member.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		member.setEmail(request.getParameter("email"));
		String userid = request.getParameter("userid");

		if (userid == null || userid.isEmpty()) {
			memberDetails.addMemberDetails(member);

		} else {
			member.setUserid(Integer.parseInt(userid));	
			memberDetails.updateMemberDetails(member);

		}

		RequestDispatcher rd = request.getRequestDispatcher(listMember);
		request.setAttribute("users", dao.getAllMembers());
		rd.forward(request, response);
	}
}