package com.qsp.statement.statics.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qsp.statement.statics.connection.EmployConnection;
import com.qsp.statement.statics.dto.Employ;



public class EmployDao {

	    Connection connection = null;
	
	/* this method will insert  the employee data inside employee table */
	public void insertEmploy(Employ employ) {
		
		try {
		connection = EmployConnection.getConnection();
	//  step -> 3 create the statement:
		Statement statement = connection.createStatement();
		
		String insert = "insert into employ values(" + employ.getId() +",'" + employ.getName() +"','" + employ.getEmail() +"')";
		
		
	// step -> 4 execute the query
		
		
	   statement.execute(insert);
	   
	   System.out.println("Data stored........");
	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// update method for employee table
	
	public void  updateEmploy(Employ employ) {
		
		connection = EmployConnection.getConnection();
		
		System.out.println(employ.getName());
		
		
		try {
			Statement statement = connection.createStatement();
			
			String update = "update employ set name = '"+employ.getName()+"' where id ="+employ.getId()+"";
			
			statement.executeUpdate(update);
			
			
			System.out.println("Date updated");
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//delete method for employee table
	public void deleteEmploy(Employ employ) {
		
		connection = EmployConnection.getConnection();
		
		System.out.println("employ Dao");
		
		
		try {
			Statement statement = connection.createStatement();
			
			String delete = "delete from employ where id ="+employ.getId()+"";
			
			statement.executeUpdate(delete);
			
			System.out.println("Data updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e .printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// displayMethod for employee
	
	public List<Employ> displayEmploy() {
		
		connection = EmployConnection.getConnection();
		
		Statement statement;
		
		
		
		try {
			statement = connection.createStatement();
			
			
			String select = "SELECT * FROM  employ";
			
			ResultSet resultSet= statement.executeQuery(select);
			
			List<Employ> employees = new ArrayList<Employ>();
			
			
			while(resultSet.next()) {
				
				Employ employ = new Employ();
				
				
				employ.setId(resultSet.getInt("id"));
				employ.setName(resultSet.getString("name"));
				employ.setEmail(resultSet.getString("email"));
				employees.add(employ);
				
			}
			
			return employees;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}

}
