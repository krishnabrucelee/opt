/**
 * 
 */
package com.java.librarymanagement.service;

import com.java.librarymanagement.model.dao.BookDao;
import com.java.librarymanagement.model.entity.BookEntity;

/**
 * @author Krishna
 * Service Class for Books
 */
public class BookServiceImpl implements BookService {

	/**
	 * @param BookDetails
	 * @return bookId
	 */
	public int getBookDetails(int bookId) {
		BookDao dao = new BookDao();
		dao.deleteBook(bookId);

		return bookId;
	}

	/**
	 * @param bookEntity
	 */
	public void addBookDetails(BookEntity bookEntity) {
		BookDao dao = new BookDao();
		dao.addBook(bookEntity);
	}

	/**
	 * @param bookEntity
	 */
	public void updateBookDetails(BookEntity bookEntity) {
		BookDao dao = new BookDao();
		dao.updateBook(bookEntity);
	}

	/**
	 * @return Object
	 */
	public Object getAllBookDetails() {
		BookDao dao = new BookDao();
		dao.getAllBooks();
		return null;
	}
}
