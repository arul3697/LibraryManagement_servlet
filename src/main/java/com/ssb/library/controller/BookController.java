package main.java.com.ssb.library.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import main.java.com.ssb.library.model.Book;
import main.java.com.ssb.library.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookControl
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)//50MB
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (request.getParameter("redirectValue").equals("Add")) {
				Book book = new Book();
				String name = request.getParameter("name");
				String author_name = request.getParameter("author_name");
				String publisher_name = request.getParameter("publisher_name");
				String contact_number = request.getParameter("contact_number");
				
				String folderName = "resource";
				String uploadpath = request.getServletContext().getRealPath("") + File.separator + folderName;
				
				File dir = new File(uploadpath);
				if(!dir.exists()) {
					dir.mkdir();
				}
                Part filePart = request.getPart("file");
                							
				book.setName(name);
				book.setAuthor_name(author_name);
				book.setPublisher_name(publisher_name);
				book.setContact_number(contact_number);
				book.setAccount_enabled(true);
				
				String fileName =filePart.getSubmittedFileName();
				String path = folderName + File.separator + fileName;
				book.setFileName(fileName);
				book.setPath(path);
				InputStream inputStream = filePart.getInputStream();
				Files.copy(inputStream,Paths.get(uploadpath + File.separator + fileName ), StandardCopyOption.REPLACE_EXISTING);
				
				BookServiceImpl.getInstance().add(book);
				request.setAttribute("message", "Book Successfully added");
				request.setAttribute("view_id", 2);
				request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("redirectValue").equals("Update")) {
				Book book = new Book();
				String name = request.getParameter("name");
				String author_name = request.getParameter("author_name");
				String publisher_name = request.getParameter("publisher_name");
				String contact_number = request.getParameter("contact_number");
								
				int id = Integer.parseInt(request.getParameter("id"));
				book = BookServiceImpl.getInstance().getBook_id(id);
				
				String folderName = "resource";
				String uploadpath = request.getServletContext().getRealPath("") + File.separator + folderName;
				
				File dir = new File(uploadpath);
				if(!dir.exists()) {
					dir.mkdir();
				}
                Part filePart = request.getPart("file");
                
				book.setId(id);
				book.setName(name);
				book.setAuthor_name(author_name);
				book.setPublisher_name(publisher_name);
				book.setContact_number(contact_number);
				book.setAccount_enabled(true);
				
				String fileName =filePart.getSubmittedFileName();
				String path = folderName + File.separator + fileName;
				book.setFileName(fileName);
				book.setPath(path);
				InputStream inputStream = filePart.getInputStream();
				Files.copy(inputStream,Paths.get(uploadpath + File.separator + fileName ), StandardCopyOption.REPLACE_EXISTING);
				
				BookServiceImpl.getInstance().updateBook(book);
				request.setAttribute("update", "Updated Successfully!!!");
				request.setAttribute("view_id", 2);
				request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
				
			} else if (request.getParameter("redirectValue").equals("Submit")) {
				Book book = new Book();
				String name = request.getParameter("name");
				String author_name = request.getParameter("author_name");
				String publisher_name = request.getParameter("publisher_name");
				String contact_number = request.getParameter("contact_number");
                
				String folderName = "resource";
				String uploadpath = request.getServletContext().getRealPath("") + File.separator + folderName;
				
				File dir = new File(uploadpath);
				if(!dir.exists()) {
					dir.mkdir();
				}
                Part filePart = request.getPart("file");
				
				book.setName(name);
				book.setAuthor_name(author_name);
				book.setPublisher_name(publisher_name);
				book.setContact_number(contact_number);
				book.setAccount_enabled(true);
				
				String fileName =filePart.getSubmittedFileName();
				String path = folderName + File.separator + fileName;
				book.setFileName(fileName);
				book.setPath(path);
				InputStream inputStream = filePart.getInputStream();
				Files.copy(inputStream,Paths.get(uploadpath + File.separator + fileName ), StandardCopyOption.REPLACE_EXISTING);
				
				BookServiceImpl.getInstance().add(book);
				request.setAttribute("message", "Book Successfully added");
				request.setAttribute("view_id", 3);
				request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("redirectValue").equals("Confirm")) {
				Book book = new Book();
				String name = request.getParameter("name");
				String author_name = request.getParameter("author_name");
				String publisher_name = request.getParameter("publisher_name");
				String contact_number = request.getParameter("contact_number");

				int id = Integer.parseInt(request.getParameter("id"));
				book = BookServiceImpl.getInstance().getBook_id(id);
				
				String folderName = "resource";
				String uploadpath = request.getServletContext().getRealPath("") + File.separator + folderName;
				
				File dir = new File(uploadpath);
				if(!dir.exists()) {
					dir.mkdir();
				}
                Part filePart = request.getPart("file");
				
				book.setId(id);
				book.setName(name);
				book.setAuthor_name(author_name);
				book.setPublisher_name(publisher_name);
				book.setContact_number(contact_number);
				book.setAccount_enabled(true);
				
				String fileName =filePart.getSubmittedFileName();
				String path = folderName + File.separator + fileName;
				book.setFileName(fileName);
				book.setPath(path);
				InputStream inputStream = filePart.getInputStream();
				Files.copy(inputStream,Paths.get(uploadpath + File.separator + fileName ), StandardCopyOption.REPLACE_EXISTING);
				
				BookServiceImpl.getInstance().updateBook(book);
				request.setAttribute("update", "Updated Successfully!!!");
				request.setAttribute("view_id", 3);
				request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
				rd.forward(request, response);
			}
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				request.setAttribute("updateError", "Error!!Try again");
				try {
					request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				} catch (Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("addbook.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("redirectValue").equals("view")) {
			try {
				List<Book> books = BookServiceImpl.getInstance().viewBook();
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("view_id", id);
				request.setAttribute("book", books);
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				try {
					request.setAttribute("bookError", "Error!!Try again");
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("editBook")) {
			Book book = new Book();
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				book = BookServiceImpl.getInstance().getBook_id(id);
				request.setAttribute("book", book);
				RequestDispatcher rd = request.getRequestDispatcher("addbook.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("Error", "Error!!Try again");
					try {

						request.setAttribute("books", BookServiceImpl.getInstance().viewBook());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					request.setAttribute("view_id", 2);
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("deleteBook")) {
			try {
				Book book = new Book();
				int id = Integer.parseInt(request.getParameter("id"));
				book = BookServiceImpl.getInstance().getBook_id(id);
				book.setAccount_enabled(false);
				BookServiceImpl.getInstance().disableBook(book);
				request.setAttribute("deletemessage", "Deleted SuccessFully!!!");
				request.setAttribute("view_id", 2);
				request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("Error", "Delete Process Failed!!Try again");
					try {
						request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					request.setAttribute("view_id", 2);
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("viewUserBook")) {
			try {
				List<Book> books = BookServiceImpl.getInstance().viewBook();
				request.setAttribute("book", books);
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("view_id", id);
				RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				try {
					request.setAttribute("bookError", "Error!!Try again");
					RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("views")) {
			try {
				List<Book> books = BookServiceImpl.getInstance().viewBook();
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("view_id", id);
				request.setAttribute("book", books);
				RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				try {
					request.setAttribute("bookError", "Error!!Try again");
					RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("editBooks")) {
			Book book = new Book();
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				book = BookServiceImpl.getInstance().getBook_id(id);
				request.setAttribute("book", book);
				RequestDispatcher rd = request.getRequestDispatcher("addLibrarianBook.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("Error", "Error!!Try again");
					try {

						request.setAttribute("books", BookServiceImpl.getInstance().viewBook());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					request.setAttribute("view_id", 3);
					RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (request.getParameter("redirectValue").equals("deleteBooks")) {
			try {
				Book book = new Book();
				int id = Integer.parseInt(request.getParameter("id"));
				book = BookServiceImpl.getInstance().getBook_id(id);
				book.setAccount_enabled(false);
				BookServiceImpl.getInstance().disableBook(book);
				request.setAttribute("deletemessage", "Deleted SuccessFully!!!");
				request.setAttribute("view_id", 3);
				request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
				RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("Error", "Delete Process Failed!!Try again");
					try {
						request.setAttribute("book", BookServiceImpl.getInstance().viewBook());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					request.setAttribute("view_id", 3);
					RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
					rd.forward(request, response);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
