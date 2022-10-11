package com.perfios.dao;

import java.time.LocalDate;
import java.util.Date;

public class TransactionsDao {

	public boolean transactions(long account_number,String type,double amount, LocalDate transDate,String userName) {
		StatementDao sd=new StatementDao();
		boolean status=false;
		
		try {
			
			String sql="insert into transactions values("+account_number+","+amount+",'"+type+"','"+transDate+"','"+userName+"')";
			
			if(sd.getStatement().executeUpdate(sql)>=1) {
				status=true;
			}
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return status;
		
	}
}
