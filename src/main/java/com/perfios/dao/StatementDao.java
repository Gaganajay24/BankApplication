package com.perfios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StatementDao {

	public Statement getStatement() {
		Statement st=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","password");
		st=con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return st;
		
	}
}
