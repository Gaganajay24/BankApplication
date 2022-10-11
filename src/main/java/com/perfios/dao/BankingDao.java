//package com.perfios.dao;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class BankingDao {
//	
//		public Statement getStatement() {
//		Statement st=null;
//		try {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","password");
//		st=con.createStatement();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return st;
//		
//	}
//		
//		public ResultSet get_amount() {
//			
//			ResultSet rs=null;
//			try {
//				
//				String sql="select amount,userName from userAccount";
//				rs=getStatement().executeQuery(sql);
//				
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			return rs;
//		}
//		
//		public long get_Account_Number(String username) {
//			
//			long account_number=0;
//			try {
//				
//				String sql="select account_number from userAccount where userName='"+username+"'";
//				ResultSet rs=getStatement().executeQuery(sql);
//				if(rs.next()) {
//					account_number=rs.getLong(1);
//					
//				}
//				
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			return account_number;
//		}
//		
//		public boolean transfer(int balance,long account_number ,int amount,String userName) {
//			
//			boolean status=false;
//			try {
//				String sql="select amount from userAccount where account_number="+account_number;
//				ResultSet rs=getStatement().executeQuery(sql);
//				if(rs.next()) {
//				int amountCredit=amount+rs.getInt(1);
//				int amountDebit=balance-amount;
//				
//				String sql1="update userAccount set amount="+amountCredit+" where account_number="+account_number;
//				String sql2="update userAccount set amount="+amountDebit+" where userName='"+userName+"'";
//				if((getStatement().executeUpdate(sql1)>=1)&&(getStatement().executeUpdate(sql2)>=1)) {
//					status=true;
//					long sender_account_number=get_Account_Number(userName);
//					transactions(sender_account_number,"Db",amount);
//					transactions(account_number,"Cr",amount);
//				}
//				}
//				
//				
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			return status;
//		}
//		
//		public boolean transactions(long account_number,String type,int amount) {
//			boolean status=false;
//			
//			try {
//				
//				String sql="insert into transactions values("+account_number+","+amount+",'"+type+"')";
//				
//				if(getStatement().executeUpdate(sql)>=1) {
//					status=true;
//				}
//				
//				
//			}
//			catch(Exception e) {
//				
//				e.printStackTrace();
//			}
//			return status;
//			
//		}
//		
//		public ResultSet getAllTransactionStatements(long account_number) {
//			
//			ResultSet rs=null;
//			try {
//				
//				String sql="select * from transactions where account_number="+account_number;
//				rs=getStatement().executeQuery(sql);
//				
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			return rs;
//		}
//		
//		
//		
//
//}
