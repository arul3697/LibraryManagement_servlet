package main.java.com.ssb.library.service.impl;

import java.util.List;

import main.java.com.ssb.library.dao.impl.BookDaoImpl;
import main.java.com.ssb.library.model.Book;
import main.java.com.ssb.library.service.BookService;

public class BookServiceImpl implements BookService {
	// create singleton for bookService
	private static BookService bookService;

	public static BookService getInstance() {
		if (bookService == null) {
			bookService = new BookServiceImpl();
		}
		return bookService;
	}

	/**
	 * add book in list
	 * 
	 * @param book object
	 * @return
	 * @throws Exception
	 */
	public Book add(Book book) throws Exception {
		return BookDaoImpl.getInstance().add(book);
	}

	/**
	 * List of Book
	 * 
	 * @return boolean value
	 * @throws Exception
	 */
	public List<Book> viewBook() throws Exception {
		return BookDaoImpl.getInstance().viewBook();
	}

	/**
	 * delete book
	 * 
	 * @param bookId
	 * @return boolean value
	 * @throws Exception
	 */
	public void disableBook(Book book) throws Exception {
		BookDaoImpl.getInstance().disableBook(book);
	}

	@Override
	public Book getBook_id(int id) throws Exception {
		return BookDaoImpl.getInstance().getBook_id(id);
	}

	@Override
	public void updateBook(Book book) throws Exception {
		BookDaoImpl.getInstance().updateBook(book);

	}
}
