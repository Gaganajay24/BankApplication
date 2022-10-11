package com.perfios.dao;

import java.sql.ResultSet;
import java.time.LocalDate;


public class TransferDao {

	public boolean transfer(double balance,long account_number ,double amount,String userName,LocalDate transDate) {
		StatementDao sd=new StatementDao();
		TransactionsDao td=new TransactionsDao();
		AccountNumberDao ad=new AccountNumberDao();
		boolean status=false;
		try {
			String sql="select amount from userAccount where account_number="+account_number;
			ResultSet rs=sd.getStatement().executeQuery(sql);
			if(rs.next()) {
			double amountCredit=amount+rs.getDouble(1);
			double amountDebit=balance-amount;
			
			String sql1="update userAccount set amount="+amountCredit+" where account_number="+account_number;
			String sql2="update userAccount set amount="+amountDebit+" where userName='"+userName+"'";
			if((sd.getStatement().executeUpdate(sql1)>=1)&&(sd.getStatement().executeUpdate(sql2)>=1)) {
				status=true;
				long sender_account_number=ad.get_Account_Number(userName);
				td.transactions(sender_account_number,"Debit",amount,transDate,userName);
				td.transactions(account_number,"Credit",amount,transDate,userName);
			}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
