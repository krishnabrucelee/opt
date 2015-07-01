/**
 * 
 */
package com.java.librarymanagement.model.entity;

/**
 * @author Krishna
 * Entity Class for Books
 */
public class BookEntity {

	private int bookid;
	private String title;
	private String author;

	/**
	 * @return the bookid
	 */
	public int getBookid() {
		return bookid;
	}

	/**
	 * @param bookid
	 *            the bookid to set
	 */
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	
	@Override
	public String toString() {
		return "BookEntity [bookid=" + bookid + ", title=" + title + ", author=" + author + "]";
	}

	
}
