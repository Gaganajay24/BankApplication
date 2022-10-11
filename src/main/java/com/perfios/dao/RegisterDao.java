package com.perfios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.perfios.dto.BankingPojo;

public class RegisterDao {
	
	static StatementDao sd=new StatementDao();
	
	public long registerValidation(BankingPojo bp) {
		long accountNumber=0;
		
		try {
			
			 String  sql = "select max(account_number) from userAccount";
			 ResultSet rs=sd.getStatement().executeQuery(sql);

             if (rs.next()) {
                 if (rs.getLong(1) == 0) {
                     accountNumber=10000000000L;
                 }
                 else {

                     accountNumber=rs.getLong(1) + 1L;

                 }
             }
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return accountNumber;
	}
	
	public boolean AccountInsertion(BankingPojo bp) {
		
		boolean status=false;
		try {
		
		String sql="insert into userAccount values("+bp.getAccount_number()+",'"+bp.getUserName()+"','"+bp.getEmailid()+"','"+bp.getName()+"',"+bp.getPhone_number()+",'"+bp.getPassword()+"',"+bp.getAmount()+")";
		
			if(sd.getStatement().executeUpdate(sql)>=1) {
				status=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

}
