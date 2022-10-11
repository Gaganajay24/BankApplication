package com.perfios.banking;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.perfios.dao.CreditCardDao;


@WebServlet("/CreditCardValidation")
@MultipartConfig(maxFileSize = 16177215)
public class CreditCardValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static CreditCardDao cd=new CreditCardDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		 InputStream adharInputStream = null;
		 InputStream panInputStream = null;
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		Part adhar = request.getPart("adhar");
		Part pan = request.getPart("pan");
        if (adhar != null) {
            // prints out some information for debugging
            System.out.println(adhar.getName());
            System.out.println(adhar.getSize());
            System.out.println(adhar.getContentType());
             
            // obtains input stream of the upload file
            adharInputStream = adhar.getInputStream();
            
            System.out.println(adharInputStream);
        }
        
        if (pan != null) {
            // prints out some information for debugging
            System.out.println(pan.getName());
            System.out.println(pan.getSize());
            System.out.println(pan.getContentType());
             
            // obtains input stream of the upload file
            panInputStream = pan.getInputStream();
            
            System.out.println(panInputStream);
        }
        
        if(cd.addData(name, age, adharInputStream, panInputStream,username,"pending")) {
        	
        	RequestDispatcher rd=request.getRequestDispatcher("creditcard.jsp");
        	rd.forward(request, response);
        }
	
	}

}
