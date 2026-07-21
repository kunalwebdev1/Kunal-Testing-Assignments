package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTest {
	@Test
	public void testDatabaseConnection() throws ClassNotFoundException, SQLException {
		// Define connection parameters
		String databaseURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";
		String user = "root";
		String password = "testing";
		
		// Load JDBC Driver and get connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to Database");
		Connection con = DriverManager.getConnection(databaseURL, user, password);
		Statement stmt = con.createStatement();
		
		// Execute a query
		String query = "SELECT * FROM seleniumautomation.book_detl;";
		ResultSet rs = stmt.executeQuery(query);
		
		// Process the results 
		while (rs.next()) {
			String auth = rs.getString("author");
			String tit = rs.getString("title");
			System.out.println("author: " + auth + ", title: " + tit);
		}
		
		// Close the connection
		con.close();
		
	}
}
