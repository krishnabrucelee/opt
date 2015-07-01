/**
 * 
 */
package com.java.librarymanagement.service;

import com.java.librarymanagement.model.entity.BookEntity;

/**
 * @author Krishna
 * Service Class for Books
 *
 */
public interface BookService {

	public Object getAllBookDetails();

	public int getBookDetails(int bookId);

	public void addBookDetails(BookEntity bookEntity);

	public void updateBookDetails(BookEntity bookEntity);

}
