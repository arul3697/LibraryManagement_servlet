package main.java.com.ssb.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.ssb.library.model.Role;
import main.java.com.ssb.library.model.User;
import main.java.com.ssb.library.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserControl
 * @ author Arulselvan S 
 */
@WebServlet("/UserControl")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {

			if (request.getParameter("redirectValue").equals("Add")) {
				String name = request.getParameter("name");
				String pass = request.getParameter("password");
				String email_id = request.getParameter("email_id");
				String address = request.getParameter("address");
				String contact_number = request.getParameter("contact_number");

				user.setName(name);
				boolean isverificationName = UserServiceImpl.getInstance().name(user);
				if (!isverificationName) {
					request.setAttribute("nameError", "Already user name takened! Try another");
				}
				user.setPassword(pass);
				user.setAddress(address);
				user.setEmail_id(email_id);
				boolean isverificationEmail = UserServiceImpl.getInstance().email_id(user);
			    	if (!isverificationEmail) {

					request.setAttribute("MailError", "Already used email! Try another");

				}
				user.setContact_number(contact_number);
				boolean isVerification = UserServiceImpl.getInstance().contact_numberVerification(user);
				if (!isVerification) {

					request.setAttribute("MobileError", "Already used Contact number! Try another");
				}
				user.setAccount_enabled(true);
				Role role = new Role();
				role.setId(3);
				user.setRole(role);
				
				UserServiceImpl.getInstance().createUser(user);
				request.setAttribute("message", " User Successfully added");
				request.setAttribute("view_id", 1);
				request.setAttribute("users", UserServiceImpl.getInstance().viewUser());
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("redirectValue").equals("Update")) {
				String name = request.getParameter("name");
				String email_id = request.getParameter("email_id");
				String address = request.getParameter("address");
				String contact_number = request.getParameter("contact_number");

				int id = Integer.parseInt(request.getParameter("id"));
				user = UserServiceImpl.getInstance().getUser_id(id);

				user.setId(id);
				user.setName(name);
				boolean isverificationName = UserServiceImpl.getInstance().name(user);
				if (!isverificationName) {
					request.setAttribute("nameError", "Already user name takened! Try another");
				}
				user.setPassword(user.getPassword());
				user.setEmail_id(email_id);
				boolean isverification = UserServiceImpl.getInstance().email_id(user);
				if (!isverification) {
					request.setAttribute("MailError", "Already used email! Try another");
				}
				user.setAddress(address);
				user.setContact_number(contact_number);
				boolean isVerification = UserServiceImpl.getInstance().contact_numberVerification(user);
				if (!isVerification) {
					request.setAttribute("MobileError", "Already used Contact number!Try another");
				}
				UserServiceImpl.getInstance().updateUser(user);
				request.setAttribute("update", "Updated Successfully!!!");
				request.setAttribute("view_id", 1);
				request.setAttribute("users", UserServiceImpl.getInstance().viewUser());
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception ex) {
			try {
				//ex.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("redirectValue").equals("view")) {
			try {
				List<User> users = UserServiceImpl.getInstance().viewUser();
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("view_id", id);
				request.setAttribute("users", users);
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("userError", "Error!!Try again");
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("edit")) {
			User user = new User();
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				user = UserServiceImpl.getInstance().getUser_id(id);
				request.setAttribute("users", user);
				RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("Error", "Error!!Try again");
					try {
						request.setAttribute("users", UserServiceImpl.getInstance().viewUser());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					request.setAttribute("view_id", 1);
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}

		} else if (request.getParameter("redirectValue").equals("deleteAccount")) {
			try {
				User user = new User();
				int id = Integer.parseInt(request.getParameter("id"));
				user = UserServiceImpl.getInstance().getUser_id(id);
				user.setAccount_enabled(false);
				UserServiceImpl.getInstance().disableAccount(user);
				request.setAttribute("deletemessage", "User account de-activated!!!");
				request.setAttribute("view_id", 1);
				request.setAttribute("users", UserServiceImpl.getInstance().viewUser());
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("deactivateError", "De-Activation Failed!!Try again");
					try {
						request.setAttribute("users", UserServiceImpl.getInstance().viewUser());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					request.setAttribute("view_id", 1);
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
