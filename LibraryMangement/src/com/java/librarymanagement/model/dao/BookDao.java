/**
 * 
 */
package com.java.librarymanagement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.librarymanagement.model.entity.BookEntity;
import com.java.librarymanagement.utils.DbUtil;

/**
 * @author Krishna
 *
 */
public class BookDao {
	private Connection connection;

	public BookDao() {
		connection = DbUtil.getConnection();
	}

	// Add Books
	public void addBook(BookEntity bookEntity) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into books(title,author) values (?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, bookEntity.getTitle());
			preparedStatement.setString(2, bookEntity.getAuthor());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete Books
	public void deleteBook(int bookId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from books where bookid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, bookId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Books
	public void updateBook(BookEntity bookEntity) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update books set title=?, author=?" + "where bookid=?");
			// Parameters start with 1
			preparedStatement.setString(1, bookEntity.getTitle());
			preparedStatement.setString(2, bookEntity.getAuthor());
			preparedStatement.setInt(3, bookEntity.getBookid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// List All Books
	public List<BookEntity> getAllBooks() {
		List<BookEntity> bookEntities = new ArrayList<BookEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			while (rs.next()) {
				BookEntity bookEntity = new BookEntity();
				bookEntity.setBookid(rs.getInt("bookid"));
				bookEntity.setTitle(rs.getString("title"));
				bookEntity.setAuthor(rs.getString("author"));

				bookEntities.add(bookEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookEntities;
	}

	// List by bookId
	public BookEntity getBookById(int bookId) {
		BookEntity bookEntity = new BookEntity();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from books where bookid=?");
			preparedStatement.setInt(1, bookId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bookEntity.setBookid(rs.getInt("bookid"));
				bookEntity.setTitle(rs.getString("title"));
				bookEntity.setAuthor(rs.getString("author"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookEntity;
	}

	
}
