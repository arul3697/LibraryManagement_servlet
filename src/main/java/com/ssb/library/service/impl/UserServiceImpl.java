package main.java.com.ssb.library.service.impl;

import java.util.List;

import main.java.com.ssb.library.dao.impl.UserDaoImpl;
import main.java.com.ssb.library.model.User;
import main.java.com.ssb.library.service.UserService;

public class UserServiceImpl implements UserService {
	// create singleton for userService
	private static UserService userService;

	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public User createUser(User user) throws Exception {

		return UserDaoImpl.getInstance().createUser(user);
	}

	@Override
	public User userLogin(User userCredential) throws Exception {

		User user = UserDaoImpl.getInstance().userLogin(userCredential);
		try {
			if (!user.getPassword().equals(userCredential.getPassword())) {

				throw new Exception("Invalid EmailId or Password");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return user;

	}
	
	@Override
	public boolean name(User user) throws Exception {
		return UserDaoImpl.getInstance().name(user);
	}

	@Override
	public boolean email_id(User user) throws Exception {
		return UserDaoImpl.getInstance().email_id(user);
	}

	@Override
	public List<User> viewUser() throws Exception {
		return UserDaoImpl.getInstance().viewUser();

	}

	@Override
	public void passwordReset(User user) throws Exception {
		UserDaoImpl.getInstance().passwordReset(user);

	}

	@Override
	public boolean contact_numberVerification(User user) throws Exception {
		return UserDaoImpl.getInstance().contact_numberVerification(user);
	}

	@Override
	public void disableAccount(User user) throws Exception {
		UserDaoImpl.getInstance().disableAccount(user);

	}

	@Override
	public User getUser_id(int id) throws Exception {
		return UserDaoImpl.getInstance().getUser_id(id);
	}
	
	@Override
	public User getUser_email(String email_id) throws Exception {
		return UserDaoImpl.getInstance().getUser_email(email_id);
	}

	@Override
	public void updateUser(User user) throws Exception {
		UserDaoImpl.getInstance().updateUser(user);

	}
}
