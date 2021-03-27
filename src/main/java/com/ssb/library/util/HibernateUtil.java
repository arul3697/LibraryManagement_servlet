package main.java.com.ssb.library.util;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import main.java.com.ssb.library.model.Book;
import main.java.com.ssb.library.model.Role;
import main.java.com.ssb.library.model.User;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {

		try {

			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/library");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "root");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			prop.setProperty("hibernate.hbm2ddl.auto", "update");
			prop.setProperty("hibernate.show_sql", "true");
			sessionFactory = new Configuration().addProperties(prop).addAnnotatedClass(User.class)
					.addAnnotatedClass(Role.class).addAnnotatedClass(Book.class).buildSessionFactory();

		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * <p>
	 * Creating hibernate sessions
	 * </p>
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	/**
	 * <p>
	 * Closing those used sessions here
	 * </p>
	 * 
	 * @param session
	 */
	public static void closeSession(Session session) {

		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
