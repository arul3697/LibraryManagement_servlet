package main.java.com.ssb.library.dao;

import java.util.List;

import main.java.com.ssb.library.model.User;

public interface UserDao {
	User createUser(User user) throws Exception;

	User userLogin(User userLogin) throws Exception;

	List<User> viewUser() throws Exception;
	
	boolean name(User user) throws Exception;

	boolean email_id(User user) throws Exception;

	void passwordReset(User user) throws Exception;

	boolean contact_numberVerification(User user) throws Exception;

	void disableAccount(User user) throws Exception;

	User getUser_id(int id) throws Exception;
	
	User getUser_email(String email_id) throws Exception;

	void updateUser(User user) throws Exception;
}