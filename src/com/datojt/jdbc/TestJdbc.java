package com.datojt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String password="hbstudent";
		
		try {
			System.out.println("Connection to database : "+jdbcUrl);
			
			Connection myConn= DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("Connection successfull!!!!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
