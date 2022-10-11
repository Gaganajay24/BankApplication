package com.perfios.dao;

public class UpdateBalanceDao {
	
	public boolean updateBalance(double balance,String username) {
		
		boolean status=false;
		StatementDao sd=new StatementDao();
		try {
			
			String sql="update userAccount set amount="+balance+" where userName='"+username+"'";
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
