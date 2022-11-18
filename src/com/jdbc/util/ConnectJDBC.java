package com.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {
	private static Connection con;
	static {	
		try{  
			String url = "jdbc:mysql://localhost:3306/first?useSSL=false";
	        String user = "root";
	        String pass = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection( url, user, pass);  
		}
		catch(Exception e){ 
			System.out.println(e);  
		}  
	}
	
	public static Connection getConnection () {
		return con;
	} 
	
	

}
