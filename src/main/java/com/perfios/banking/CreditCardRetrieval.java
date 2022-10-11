package com.perfios.banking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfios.dao.CreditCardDao;

/**
 * Servlet implementation class CreditCardRetrieval
 */

public class CreditCardRetrieval {
	
	CreditCardDao cd=new CreditCardDao();
	public void cardRetrieval() {
		try {
			ResultSet rs=cd.getData();
			Blob blob = rs.getBlob(3);
			byte[] byteArr =  
				blob.getBytes(1,(int)blob.length());

			FileOutputStream fileOutputStream = 
			   new FileOutputStream("F:\\savedImage.jpg");
			fileOutputStream.write(byteArr);  
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
