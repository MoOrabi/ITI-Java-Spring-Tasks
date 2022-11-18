package com.jdbc.dao;

import java.sql.SQLException;

public interface EmployeeDAO {
	void add(int id,String name,String phoneNumber) throws SQLException;
	void update(int id,String name,String phoneNumber) throws SQLException;
	void delete(int id) throws SQLException;
	void search(String name) throws SQLException;
	void getAll() throws SQLException;
	
}
