package main.java.com.ssb.library.config;

import main.java.com.ssb.library.model.User;

public class SessionManagement {
	private static ThreadLocal<User> session = new ThreadLocal<User>();

	public static void setSession(User user) {
		session.set(user);
	}

	public static User getSession() {
		return session.get();
	}

	public static void remove() {
		session.remove();
	}
}
