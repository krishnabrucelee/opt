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
 * Servlet implementation class MemberController
 */
@WebServlet("/ListMemberController")
public class ListMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/WEB-INF/views/member/addMember.jsp";
	private static String LIST_MEMBER = "/WEB-INF/views/member/listMember.jsp";
	private MemberDao dao;

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

		if (action.equalsIgnoreCase("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			MemberService memberDetails = new MemberServiceImpl();
			memberDetails.getMemberDetails(userId);
			forward = LIST_MEMBER;
			request.setAttribute("users", dao.getAllMembers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt(request.getParameter("userId"));
			MemberEntity member = dao.getUserById(userId);
			request.setAttribute("user", member);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_MEMBER;
			request.setAttribute("users", dao.getAllMembers());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberEntity member = new MemberEntity();
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
			dao.addUser(member);
		} else {
			member.setUserid(Integer.parseInt(userid));
			dao.updateUser(member);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_MEMBER);
		request.setAttribute("users", dao.getAllMembers());
		view.forward(request, response);
	}
}