package com.jdbc.sajid.dao;

import java.sql.SQLException;

import com.jdbc.sajid.entity.Employee;

public interface EmployeeDao {

	public void saveEmployee(Employee e) throws SQLException ;
	
	public void updateEmployee(Employee e) throws SQLException ;
	
	public void deleteEmployee(int id) throws SQLException ;
	
	public Employee getEmployeeById(int id) throws SQLException ;

	
	public void printAllEmployees() throws SQLException ;


	
} 
