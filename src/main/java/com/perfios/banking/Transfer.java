package com.perfios.banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perfios.dao.AmountDao;
import com.perfios.dao.TransferDao;
import com.perfios.dao.UserNameDao;




@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	static AmountDao ad=new AmountDao();
	static TransferDao td=new TransferDao();
	static UserNameDao ud=new UserNameDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		long account_number=Long.parseLong(request.getParameter("account_number"));
		
		double amount=Double.parseDouble(request.getParameter("amount"));
		double balance=0;
		
		
		LocalDate date = LocalDate.now();
		
			
			try {
				ResultSet rs=ad.get_amount(username);
				ResultSet rs1=ud.getUserName(account_number);
				while(rs.next()) {
				
					balance=rs.getDouble(1);
					if(balance<amount) {
						RequestDispatcher rd=request.getRequestDispatcher("transfer.jsp?balanceflag="+true);
						rd.forward(request, response);
						break;
					}
					
				}
				
				while(rs1.next()) {
					
					if(rs1.getString(1).equals(username)) {
						RequestDispatcher rd=request.getRequestDispatcher("transfer.jsp?accflag="+true);
						rd.forward(request, response);
						break;
					}
				}
					
						
						//System.out.println("this is transfer");
						if(td.transfer(balance, account_number,amount,username,date)) {
							//System.out.println("transfer complete");
							RequestDispatcher rd=request.getRequestDispatcher("transfer.jsp?successflag="+true);
							rd.forward(request, response);
							
						}
						else {
							RequestDispatcher rd=request.getRequestDispatcher("transfer.jsp?failflag="+true);
							rd.forward(request, response);
							
						}
						
					
					
				
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}

}
