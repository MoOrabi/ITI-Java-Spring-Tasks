package com.jdbc.main;


import com.jdbc.dao.EmployeeDAOImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		
		EmployeeDAOImpl empl=new EmployeeDAOImpl();
		empl.getAll();
	}

}
