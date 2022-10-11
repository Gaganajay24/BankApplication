package com.perfios.dao;

import java.io.InputStream;
import java.sql.ResultSet;

public class CreditCardDao {

	StatementDao sd=new StatementDao();
	
	public boolean addData(String name,int age,InputStream adhar,InputStream pan,String username,String status) {
		
		boolean st=false;
		try {
			
			String sql="insert into creditCard(name,age,adhar,pan,userName,status) values('"+name+"',"+age+",'"+adhar+"','"+pan+"','"+username+"','"+status+"')";
			if(sd.getStatement().executeUpdate(sql)>=1) {
				
				System.out.println("Success");
				st=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public ResultSet getData() {
		ResultSet rs=null;
		try {
			
			String sql="select * from creditCard";
			rs=sd.getStatement().executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getUserData(int id) {
		ResultSet rs=null;
		try {
			
			String sql="select * from creditCard where id="+id;
			rs=sd.getStatement().executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean updateStatus(int id,String status) {
		boolean st=false;
		try {
			
			System.out.println("hi");
			String sql="update creditCard set status='"+status+ "' where id='"+id+"'";
			if(sd.getStatement().executeUpdate(sql)>=1) {
				st=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
