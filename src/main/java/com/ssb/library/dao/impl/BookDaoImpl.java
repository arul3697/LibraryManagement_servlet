package main.java.com.ssb.library.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import main.java.com.ssb.library.dao.BookDao;
import main.java.com.ssb.library.model.Book;
import main.java.com.ssb.library.util.HibernateUtil;

public class BookDaoImpl implements BookDao {
	// create singleton for bookDao
	private static BookDao bookDao;

	public static BookDao getInstance() {
		if (bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}

	/**
	 * save book
	 * 
	 * @param book object
	 * @return boolean
	 * @throws Exception
	 */
	public Book add(Book book) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return book;
	}

	/**
	 * retrieve book
	 * 
	 * @return bookList
	 * @throws Exception
	 */
	public List<Book> viewBook() throws Exception {
		Session session = HibernateUtil.getSession();
		List<Book> books = new ArrayList();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Book.class).add(Restrictions.eq("account_enabled", true));
			books = criteria.list();
			transaction.commit();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * @param book
	 * @return boolean
	 * @throws Exception
	 */
	public void disableBook(Book book) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public Book getBook_id(int id) throws Exception {
		Session session = HibernateUtil.getSession();
		Book book = new Book();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Book.class).add(Restrictions.eq("id", id));
			book = (Book) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return book;
	}

	/**
	 * <p>
	 * Admin updates the book
	 * </p>
	 */
	public void updateBook(Book book) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}