package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.ConnectJDBC;

public class EmployeeDAOImpl implements EmployeeDAO {

	static Connection con=ConnectJDBC.getConnection();

	public EmployeeDAOImpl() throws Exception{
		
	}
	
	@Override
	public void add(int id,String name,String phoneNumber) throws SQLException {
		PreparedStatement stmt= con.prepareStatement("insert into employee(id,name,phone_number) values (?,?,?)");  
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3,phoneNumber);
		stmt.executeUpdate();
		
	}
	
	@Override
	public void update(int id,String name,String phoneNumber) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("update employee set id =? ,name=? ,phone_number=? where id=?");  
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3,phoneNumber);
		stmt.setInt(4, id);
		stmt.executeUpdate();
		
	}
	
	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("delete from employee where id=?");  
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
	}
	
	@Override
	public void search(String name) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("select * from employee where name=?");
		stmt.setString(1, name);
		ResultSet rs=stmt.executeQuery();
		if(!rs.next()) {
			System.out.println("Not Found");
		}
		rs.beforeFirst();
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	}
	
	@Override
	public void getAll() throws SQLException {
		PreparedStatement stmt=con.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs=stmt.executeQuery();
		
		if(!rs.first()) {
			System.out.println("Empty");
			return;
		}
		rs.previous();
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	}
}
