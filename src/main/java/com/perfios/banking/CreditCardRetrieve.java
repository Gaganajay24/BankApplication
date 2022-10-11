package com.perfios.banking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfios.dao.CreditCardDao;


@WebServlet("/CreditCardRetrieve")
public class CreditCardRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static CreditCardDao cd=new CreditCardDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		try {
//			System.out.println("Here");
//			ResultSet rs=cd.getData();
//			if(rs.next()) {
//				Blob blob = rs.getBlob("adhar");
//				
//				System.out.println(blob);
////				byte[] byteArr =  
////					blob.getBytes(1,(int)blob.length());
//
////				FileOutputStream fileOutputStream = 
////				   new FileOutputStream("/home/gagana/Downloads/savedImage.jpg");
////				fileOutputStream.write(byteArr);  
//				
//				response.setContentType("image/png");
//				OutputStream os=response.getOutputStream();
//				os.write(blob.getBytes(1, (int) blob.length()));
//				os.flush();
//				os.close();
//			}
//			
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	
		int id = Integer.parseInt(request.getParameter("id"));
		//String filename = request.getParameter("filename");
		System.out.println("id : "+id);
		OutputStream outputStream = response.getOutputStream();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + id + ".pdf");
	
		try {
			
			
			ResultSet resultSet = cd.getUserData(id);
			resultSet.next();
				System.out.println("id : "+id);
				
            Blob blob = resultSet.getBlob("adhar");
            byte[] blobInBytes = blob.getBytes(1, (int) blob.length());
            System.out.println(blobInBytes.length);
            outputStream.write(blobInBytes);
        } catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
		
		
	}

}
