package com.perfios.dao;

import java.sql.ResultSet;
import java.util.Date;

public class TransactionStatements {

	StatementDao sd=new StatementDao();
	public ResultSet getAllTransactionStatements(String username) {
		
		ResultSet rs=null;
		try {
			
			String sql="select * from transactions where From_Username='"+username+"'";
			rs=sd.getStatement().executeQuery(sql);
			
			System.out.println("this is transsat");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
public ResultSet getBetweenStatements(String username, Date From_date, Date To_Date) {
		
		ResultSet rs=null;
		try {
			
			
			
			String sql="select distinct(From_Username) from transactions where Date between'"+From_date+"' and'"+To_Date+"'";  
			rs=sd.getStatement().executeQuery(sql);
			
			System.out.println("this is datestat");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
}
