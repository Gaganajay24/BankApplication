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
import com.perfios.dao.StatementDao;
import com.perfios.dao.TransactionsDao;
import com.perfios.dao.UpdateBalanceDao;


@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static AmountDao ad=new AmountDao();
	static TransactionsDao td=new TransactionsDao();
	static StatementDao sd=new StatementDao();
	static UpdateBalanceDao ud=new UpdateBalanceDao();
	static AccountNumberDao and=new AccountNumberDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		
		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("pword");
		
		System.out.println("username is :"+username);
		LocalDate date = LocalDate.now();
		try {
			
			
			ResultSet rs=ad.get_amount(username);
			
			if(rs.next()) {
				if(rs.getDouble(1)<amount) {
					
					RequestDispatcher rd=request.getRequestDispatcher("withdraw.html");
					
					rd.include(request,response);
					out.println("<p align='bottom'>balance is lesser than withdraw</p>");

										
				
				}
				else {
					double balance=rs.getDouble(1)-amount;
					if(ud.updateBalance(balance, username)){
						long account_number=and.get_Account_Number(username);
						td.transactions(account_number, "Debit", amount,date,username);
						RequestDispatcher rd=request.getRequestDispatcher("withdraw.jsp?withdrawsflag="+true);
					
						rd.include(request,response);
						//out.println("<p align='bottom'>Money withdrawn successfully</p>");
						}
					else {
						//out.println("Withdraw failed!!");
						RequestDispatcher rd=request.getRequestDispatcher("withdraw.jsp?withdrawfflag="+true);
						
						rd.include(request,response);
					}

										
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
