package com.perfios.dao;

import java.sql.ResultSet;

public class AmountDao {

	
	public ResultSet get_amount(String username) {
		StatementDao sd=new StatementDao();
		
		ResultSet rs=null;
		try {
			
			String sql="select amount from userAccount where userName='"+username+"'";
			rs=sd.getStatement().executeQuery(sql);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
