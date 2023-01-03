package com.qsp.statement.statics.controller;

import java.util.List;

import com.qsp.statement.statics.dto.Employ;
import com.qsp.statement.statics.service.EmployService;

public class EmployController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employ employ = new Employ();
		
		EmployService employService = new EmployService();
		
		boolean b = true;
		
		while(b) {
			switch (4) {
			case 1:{
				employ.setId(101);
				employ.setName("vishal");
				employ.setEmail("singh@gmail.com");
				employService.insertEmploy(employ);
			}break;
			
			
			case 2:{
				employ.setId(101);
				employ.setName("ankit");
				employService.updateEmploy(employ);
			}break;
			
			case 3: {
				employ.setId(10);
				employService.deleteEmploy(employ);
			}break;
			
			case 4: {
				
				List<Employ> employees = employService.displayEmploy();
				for(Employ employee2:employees) {
					System.out.println(employee2.getId());
					System.out.println(employee2.getName());
					System.out.println(employee2.getEmail());
					System.out.println("...............................................................");
				}
			}break;
			default:
				break;
	
			}
			b=false;
	}

	}

}
