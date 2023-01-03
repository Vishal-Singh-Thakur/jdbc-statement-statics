package com.qsp.statement.statics.service;

import java.util.List;

import com.qsp.statement.statics.dao.EmployDao;
import com.qsp.statement.statics.dto.Employ;

public class EmployService {

	EmployDao dao = new EmployDao();
	
	// this method is for business logic
	public void insertEmploy(Employ employ) {
		 
		String name = employ.getName();
		
		if(name.length()<=14) {
			 dao.insertEmploy(employ);
		}else {
			System.out.println("Idiot please provide the name with 14 character");
		}
	}
	
	//update method for employee table
	public void updateEmploy(Employ employ) {
		dao.updateEmploy(employ);
	}
	
	//delete method for employee table
	public void deleteEmploy(Employ employ) {
		dao.deleteEmploy(employ);	
	}
	
	//display method for employee table
	public List<Employ>displayEmploy() {
		return dao.displayEmploy();
		}

}
