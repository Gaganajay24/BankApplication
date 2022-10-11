package com.perfios.dao;

import java.sql.ResultSet;

public class LoginDao {
	
	static StatementDao sd=new StatementDao();
	public ResultSet loginValidation(String username) {
		
		ResultSet rs=null;
		try {
			
			String sql="select password from userAccount where userName='"+username+"'";
			rs=sd.getStatement().executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
