package com.perfios.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perfios.dao.RegisterDao;
import com.perfios.dto.BankingPojo;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static RegisterDao rd=new RegisterDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		BankingPojo bp=new BankingPojo();
		
		HttpSession session=request.getSession();
		bp.setName(request.getParameter("name"));
		bp.setEmailid(request.getParameter("email"));
		bp.setUserName(request.getParameter("email"));
		String password=request.getParameter("pwd");
		String repassword=request.getParameter("repassword");
		bp.setPhone_number(Long.parseLong(request.getParameter("phoneNumber")));
		bp.setAmount(Double.parseDouble(request.getParameter("amount")));
		try {
			
          bp.setAccount_number(rd.registerValidation(bp));
          //System.out.println("Account Number is : "+bp.getAccount_number());
          
        	  if(!(password.equals(repassword))) {
            	  
            	
            	 // session.setAttribute("pwdstatus", "false");
            	  RequestDispatcher rd=request.getRequestDispatcher("register.jsp?pwdstatus="+false);
            	  rd.forward(request, response);
              }
              else {
            	  bp.setPassword(password);
            	  if(rd.AccountInsertion(bp)) {
            		  RequestDispatcher rd=request.getRequestDispatcher("home.html");
                	  rd.forward(request, response);
            	  }
            	  else {
            		//session.setAttribute("registerStatus", "failed");
            		  RequestDispatcher rd=request.getRequestDispatcher("register.jsp?registerStatus="+true);
                	  rd.forward(request, response);
            	  }
            	 
              }
          
         
          
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
		
	
	}

}
