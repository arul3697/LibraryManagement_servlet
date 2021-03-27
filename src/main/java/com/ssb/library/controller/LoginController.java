package main.java.com.ssb.library.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.ssb.library.model.Role;
import main.java.com.ssb.library.model.User;
import main.java.com.ssb.library.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher resdis = null;
		try {
			User login = new User();
			if (request.getParameter("redirectValue").equals("Login")) {
				login.setName(userName);
				login.setPassword(password);
				User user = UserServiceImpl.getInstance().userLogin(login);
				HttpSession session = request.getSession();
				session.setAttribute("userdetails", login);
				session.setMaxInactiveInterval(30 * 60);
				switch (user.getRole().getId()) {
				case 1:
					resdis = request.getRequestDispatcher("admin.jsp");
					resdis.forward(request, response);
					break;
				case 2:
					resdis = request.getRequestDispatcher("librarian.jsp");
					resdis.forward(request, response);
					break;
				case 3:
					request.setAttribute("userName",user.getName());
					resdis = request.getRequestDispatcher("user.jsp");
					resdis.forward(request, response);
					break;
				default:
					resdis = request.getRequestDispatcher("login.jsp");
					resdis.forward(request, response);
					break;
				}
			} else if (request.getParameter("redirectValue").equals("Register")) {
				RequestDispatcher requestDispatcher = null;
				try {
					User user = new User();
					String name = request.getParameter("name");
					String pass = request.getParameter("password");
					String email_id = request.getParameter("email_id");
					String address = request.getParameter("address");
					String contact_number = request.getParameter("contact_number");

					user.setName(name);
					boolean isverificationName = UserServiceImpl.getInstance().name(user);
					if (!isverificationName) {
						request.setAttribute("NameError", "Already user name takened! Try another");
					}
					user.setPassword(pass);
					user.setAddress(address);
					user.setEmail_id(email_id);
					boolean isverification = UserServiceImpl.getInstance().email_id(user);
					if (!isverification) {
						request.setAttribute("MailError", "Already used email! Try another");
					}
					user.setContact_number(contact_number);
					boolean isVerification = UserServiceImpl.getInstance().contact_numberVerification(user);
					if (!isVerification) {
						request.setAttribute("ContactNumberError", "Already used Contact number! Try another");
					}
					user.setAccount_enabled(true);					
					Role role = new Role();
					role.setId(3);
					user.setRole(role);					
					UserServiceImpl.getInstance().createUser(user);
					request.setAttribute("message", " User registeration Successfully");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					requestDispatcher = request.getRequestDispatcher("register.jsp");
					requestDispatcher.forward(request, response);
				}
			} else if (request.getParameter("redirectValue").equals("Reset")) {
				User user = new User();				
				String email_id = request.getParameter("email_id");
				user = UserServiceImpl.getInstance().getUser_email(email_id);
				String newPassword = request.getParameter("newpassword");
				String confirmPassword = request.getParameter("confirmpassword");
				if (newPassword.equals(confirmPassword)) {
					user.setPassword(confirmPassword);
					UserServiceImpl.getInstance().passwordReset(user);
					request.setAttribute("sucessmessage", "Password Successfully Changed");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("errormessage", "Both  Passwords Mismatched");
					RequestDispatcher rd = request.getRequestDispatcher("resetPassword.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("errormessage", "Invalid Username or password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception exception) {
			try {
				request.setAttribute("error", "Invalid Username or password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
