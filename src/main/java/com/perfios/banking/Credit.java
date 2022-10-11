package com.perfios.banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perfios.dao.AccountNumberDao;
import com.perfios.dao.AmountDao;
import com.perfios.dao.TransactionsDao;
import com.perfios.dao.UpdateBalanceDao;


@WebServlet("/Credit")
public class Credit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static AmountDao ad=new AmountDao();
    static UpdateBalanceDao ud=new UpdateBalanceDao();
    static TransactionsDao td=new TransactionsDao();
    static AccountNumberDao an=new AccountNumberDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		double amount=Double.parseDouble(request.getParameter("amount"));
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		//String password=(String)session.getAttribute("pword");
		LocalDate date = LocalDate.now();
		
		try {
			
			System.out.println("username is : "+username);
			ResultSet rs=ad.get_amount(username);
			
			if(rs.next()) {
				
				
					double balance=rs.getDouble(1)+amount;
					System.out.println("balance is : "+balance);
					if(ud.updateBalance(balance, username)) {
						
						td.transactions(an.get_Account_Number(username), "Credit", amount,date,username);
					
						RequestDispatcher rd=request.getRequestDispatcher("credit.jsp?creditsflag="+true);
						
						rd.include(request,response);
						//out.println("<p align='bottom' color='green'>Money credited successfully</p>");
						}
					else {
						
						RequestDispatcher rd=request.getRequestDispatcher("credit.jsp?creditfflag="+true);
						
						rd.include(request,response);
						//out.println("<p align='bottom color='red'>Money credition failed</p>");

					}
										
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
