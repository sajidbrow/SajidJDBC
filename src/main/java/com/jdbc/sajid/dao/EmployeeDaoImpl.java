package com.jdbc.sajid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.sajid.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Connection connection;
	
	static {
		try {
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sajid","root","Sajid@123");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
     
	@Override
	public void saveEmployee(Employee e) throws SQLException {
      Statement statement= connection.createStatement();
		statement.executeUpdate("insert into employee values ("+e.getId()+",'"+e.getName()+"','"+e.getGender()+"',"+e.getSalary()+")");
		System.out.println("TX Done..............");
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException  {
	  Statement statement= connection.createStatement();
		statement.executeUpdate("update employee set name = '"+e.getName()+"', gender = '"+e.getGender()+"' where id = "+e.getId());
		System.out.println("update employee set name = '"+e.getName()+"', gender = '"+e.getGender()+"' where id = "+e.getId());
		
	}

	@Override
	public void deleteEmployee(int id) throws SQLException  {
		  Statement statement= connection.createStatement();
			statement.executeUpdate("delete from employee where id ="+id);
			System.out.println("delete from employee where id ="+id);
			
		}
	
	@Override
	public Employee getEmployeeById(int id) throws SQLException  {
		Statement statement= connection.createStatement();
		// Result Set is a kind of table.
		ResultSet rs = statement.executeQuery("select * from employee where id = "+id);
		rs.next();
		
		Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
		
		while(rs.next()) {
			System.out.println("EmpId = " + rs.getInt(1)+ "\t Name = " +rs.getString(2)+"\t Gender = "+rs.getString(3)+"\t Salary = "+rs.getInt(4));
		}
		System.out.println("select * from employee where id = "+id);
		
		return emp;
		
		}
			
		
	
	@Override
	public void printAllEmployees() throws SQLException  {
		Statement statement= connection.createStatement();
		// Result Set is a kind of table.
		ResultSet rs = statement.executeQuery("select * from employee ");
		
		while(rs.next()) {
			System.out.println("EmpId = " + rs.getInt(1)+ "\t Name = " +rs.getString(2)+"\t Gender = "+rs.getString(3)+"\t Salary = "+rs.getInt(4));
		}
		System.out.println("select * from employee ");	
		}

}
