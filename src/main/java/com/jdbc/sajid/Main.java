package com.jdbc.sajid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.sajid.dao.EmployeeDao;
import com.jdbc.sajid.dao.EmployeeDaoImpl;
import com.jdbc.sajid.entity.Employee;

public class Main {

	public static void main(String[] args) throws SQLException {

		Employee e1 = new Employee();
		
        EmployeeDao edao = new EmployeeDaoImpl ();
		
     //   edao.saveEmployee(e1);
     //   edao.updateEmployee(e1);
     //  edao.deleteEmployee(12);
     //   edao.printAllEmployees();
        ;
         System.out.println( edao.getEmployeeById(1));
         
		System.out.println("Main.main()");
		
	}

}
