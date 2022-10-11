package com.perfios.banking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfios.dao.CreditCardDao;


@WebServlet("/CreditValues")
public class CreditValues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static CreditCardDao cd=new CreditCardDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String status=request.getParameter("status");
		
		if(cd.updateStatus(id, status)) {
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}
	
	}

	
	

}
