package main.java.com.ssb.library.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import main.java.com.ssb.library.dao.UserDao;
import main.java.com.ssb.library.model.User;
import main.java.com.ssb.library.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	// create singleton for userDao
	private static UserDao userDao;

	public static UserDao getInstance() {
		if (userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	// save users
	public User createUser(User user) throws Exception {

		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

	/**
	 * retrieve user
	 * 
	 * @return user
	 * @throws Exception
	 */
	public List<User> viewUser() throws Exception {
		// Add new List User object
		Session session = HibernateUtil.getSession();
		List<User> user = new ArrayList();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("account_enabled", true));
			user = criteria.list();
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * @param user_id
	 * @return boolean
	 * @throws Exception
	 */
	public void disableAccount(User user) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public User userLogin(User userLogin) throws Exception {

		User user = null;
		Session session = HibernateUtil.getSession();

		try {
			Transaction trans = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("name", userLogin.getName()))
					.add(Restrictions.eq("account_enabled", true));

			user = (User) criteria.uniqueResult();
			trans.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}

	}
	
	/**
	 * <p>
	 * checking for EmailId already exists or not
	 * </p>
	 */
	public boolean name(User user) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("name", user.getName()));
			user = (User) criteria.uniqueResult();
			if (user != null) {
				return false;
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * <p>
	 * checking for EmailId already exists or not
	 * </p>
	 */
	public boolean email_id(User user) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email_id", user.getEmail_id()));
			user = (User) criteria.uniqueResult();
			if (user != null) {
				return false;
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * <p>
	 * Checks the mobile already exists or not
	 * </p>
	 */
	public boolean contact_numberVerification(User user) throws Exception {
		User users = null;
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("contact_number", user.getContact_number()));
			users = (User) criteria.uniqueResult();
			if (users != null) {
				return false;
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public void passwordReset(User user) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	/**
	 * <p>
	 * Admin gets the User details by Id
	 * </p>
	 */
	public User getUser_id(int id) throws Exception {
		Session session = HibernateUtil.getSession();
		User user = new User();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("id", id));
			user = (User) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}
	public User getUser_email(String email_id) throws Exception {
		Session session = HibernateUtil.getSession();
		User user = new User();
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email_id", email_id));
			user = (User) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

	/**
	 * <p>
	 * Admin updates the user
	 * </p>
	 */
	public void updateUser(User user) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
