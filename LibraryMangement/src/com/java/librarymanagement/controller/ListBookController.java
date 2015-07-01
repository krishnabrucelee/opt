package com.java.librarymanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.librarymanagement.model.dao.BookDao;
import com.java.librarymanagement.model.entity.BookEntity;

import com.java.librarymanagement.service.BookService;
import com.java.librarymanagement.service.BookServiceImpl;

/**
 * @author Krishna 
 * Servlet implementation class ListBookController
 */
@WebServlet("/ListBookController")
public class ListBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String insert_editBook = "/WEB-INF/views/book/addBook.jsp";
	private static String listBook = "/WEB-INF/views/book/listBook.jsp";
	
	BookEntity bookEntity = new BookEntity();
	BookService bookDetails = new BookServiceImpl();
	BookDao dao = new BookDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBookController() {
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
			int bookId = Integer.parseInt(request.getParameter("bookId"));

			bookDetails.getBookDetails(bookId);

			// It forwards the response to listMember
			forward = listBook;
			request.setAttribute("books", dao.getAllBooks());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = insert_editBook;

			int bookId = Integer.parseInt(request.getParameter("bookId"));
			BookEntity bookEntity = dao.getBookById(bookId);
			request.setAttribute("book", bookEntity);
		} else if (action.equalsIgnoreCase("listBook")) {
			forward = listBook;
			request.setAttribute("books", bookDetails.getAllBookDetails());
		} else {
			forward = insert_editBook;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		bookEntity.setTitle(request.getParameter("title"));
		bookEntity.setAuthor(request.getParameter("author"));

		String bookid = request.getParameter("bookid");

		if (bookid == null || bookid.isEmpty()) {
			bookDetails.addBookDetails(bookEntity);

		} else {
			bookEntity.setBookid(Integer.parseInt(bookid));
			bookDetails.updateBookDetails(bookEntity);

		}

		RequestDispatcher rd = request.getRequestDispatcher(listBook);
		request.setAttribute("books", dao.getAllBooks());
		rd.forward(request, response);
	}
}