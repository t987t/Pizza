package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.model.DB;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null) {
			request.setAttribute("msg", "");
			request.getRequestDispatcher("Home.html").forward(request, response);
		}
	
		if(page.equals("Place Order")){
			request.getRequestDispatcher("PizzaOrder.html").forward(request, response);
			if(page.equals("Checkout")){
				String name = request.getParameter("name");
				String address = request.getParameter("username");
				String phone_number = request.getParameter("phone_number");
				
				User user = new User();
				user.setName(name);
				user.setAddress(address);
				user.setPhone_number(phone_number);
				//Access to DB
				DB db = new DB();
				try {
					db.addUser(user); //insertion
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("hi");
				request.setAttribute("msg", "Order placed");
				request.getRequestDispatcher("Home.html").forward(request, response);
			}
		
		}	
		else{
			doPost(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page.equals("Track Order")){
			
				request.getRequestDispatcher("TrackingPage.java").forward(request, response);
				
				
			}
		/*if(page.equals("login-form")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//Access to DB
			DB db = new DB();
			boolean status=false;
			try {
				status = db.checkUser(username,password);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if(status == true){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "Login Unsuccesfull");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		if(page.equals("sign-up-form")){
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = new User();
			user.setName(name);
			user.setAddress(name);
			user.setPhone_number(password);
			//Access to DB
			DB db = new DB();
			try {
				db.addUser(user); //insertion
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("msg", "Sign-Up Successfull!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}*/
	}

}








