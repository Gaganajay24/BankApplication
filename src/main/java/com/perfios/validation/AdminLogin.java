package com.perfios.validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		
		//System.out.println("User : "+user);
		
		
		
		
		
//		System.out.println("username");
//		System.out.println(session.getAttribute("username"));
		
		
		try {
			
			
			
			
			
				
				if("admin".equals(pwd)) {
					//out.println("logged in successfully");
					//System.out.println(user+","+pwd);
					
					
					
					
					RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				}
				else {
					//out.println("log in failed");
					//session.setAttribute("status", "Login failed!!");
					
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?flag="+true);
					rd.forward(request, response);
					
				}
			
			
			
			
		}
		catch(Exception e) {
		
			e.printStackTrace();
		}
		
		
		
	
	
	}

	

}
