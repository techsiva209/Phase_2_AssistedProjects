package com.mphasis;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Set the content type
		response.setContentType("text/html");
		
		//		Get the parameter values
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
//		Check for authenticity
		if(userName.equals("Ravi") && userPassword.equals("1234")) {
			
//			Get the RequestDispatcher object
			RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboard");
			
//			Forward the request
			dispatcher.forward(request, response);
	
			
		}
		else {
			response.getWriter().println("Invalid username or password!!!");
//			Get the RequestDispatcher object
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
			
//			Forward the request
			dispatcher.include(request, response);
		}
	}
}