package com.perfios.dao;

import java.sql.ResultSet;

public class AccountNumberDao {
	public long get_Account_Number(String username) {
		StatementDao sd=new StatementDao();
		long account_number=0;
		try {
			
			String sql="select account_number from userAccount where userName='"+username+"'";
			ResultSet rs=sd.getStatement().executeQuery(sql);
			if(rs.next()) {
				account_number=rs.getLong(1);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return account_number;
	}
}
