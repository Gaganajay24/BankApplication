package com.perfios.dao;

import java.sql.ResultSet;

public class DetailsDao {

	StatementDao sd=new StatementDao();
	public ResultSet getDetails(String userName) {
		
		ResultSet rs=null;
		try {
			
			String sql="select * from userAccount where userName='"+userName+"'";
			rs=sd.getStatement().executeQuery(sql);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return rs;
	}
}
