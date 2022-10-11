package com.perfios.dao;

import java.sql.ResultSet;

public class UserNameDao {
	
	StatementDao sd=new StatementDao();
	public ResultSet getUserName(long account_number) {
		ResultSet rs=null;
		try {
			
			String sql="select userName from userAccount where account_number="+account_number;
			rs=sd.getStatement().executeQuery(sql);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}

}
