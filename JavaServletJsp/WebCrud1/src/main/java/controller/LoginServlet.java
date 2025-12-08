package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import dao.AdminDao;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from form 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		
		PrintWriter out = response.getWriter();
		
		if(AdminDao.checkAdmin(admin)) {
			response.sendRedirect("adminDashboard.jsp");
		} else {
			out.print("Error Occured!");
		}
	}

}
