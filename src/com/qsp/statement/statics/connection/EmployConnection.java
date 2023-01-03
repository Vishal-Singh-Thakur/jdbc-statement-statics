package com.qsp.statement.statics.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployConnection {

	static Connection connection;
	public static Connection getConnection()  {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/jbdc-statement-statics";
		String user = "root";
		String pass = "Vishal@876";
		
		
		return connection = DriverManager.getConnection(url, user, pass);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
		

	}

}
