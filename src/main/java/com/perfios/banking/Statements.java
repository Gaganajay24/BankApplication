package com.perfios.banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perfios.dao.AccountNumberDao;
import com.perfios.dao.TransactionStatements;



@WebServlet("/Statements")
public class Statements extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static AccountNumberDao and=new AccountNumberDao();
	static TransactionStatements ts=new TransactionStatements();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		ResultSet rs=ts.getAllTransactionStatements(username);
		
		
		try {
		while(rs.next()) {
		
			
			out.println("<tr><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
		}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
