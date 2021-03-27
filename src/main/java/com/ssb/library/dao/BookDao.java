package main.java.com.ssb.library.dao;

import java.util.List;

import main.java.com.ssb.library.model.Book;

public interface BookDao {
	List<Book> viewBook() throws Exception;

	void disableBook(Book book) throws Exception;

	Book add(Book book) throws Exception;

	Book getBook_id(int id) throws Exception;

	void updateBook(Book book) throws Exception;
}
