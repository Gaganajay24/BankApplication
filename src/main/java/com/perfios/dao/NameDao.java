package com.perfios.dao;

import java.sql.ResultSet;

public class NameDao {
	
	StatementDao sd=new StatementDao();
	public String getName(Long account_number) {
		
		ResultSet rs=null;
		String name=null;
		try {
			String sql="select name from userAccount where account_number="+account_number;
			rs=sd.getStatement().executeQuery(sql);
			if(rs.next()) {
				name=rs.getString(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
public String getName(String username) {
		
		ResultSet rs=null;
		String name=null;
		try {
			String sql="select name from userAccount where userName='"+username+"'";
			rs=sd.getStatement().executeQuery(sql);
			if(rs.next()) {
				name=rs.getString(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
