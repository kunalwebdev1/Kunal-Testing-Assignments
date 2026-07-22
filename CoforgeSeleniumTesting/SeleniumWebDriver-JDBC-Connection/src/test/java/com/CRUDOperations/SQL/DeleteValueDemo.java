package com.CRUDOperations.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteValueDemo {
	Connection con;
    Statement stmt;

    String databaseURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";
    String user = "root";
    String password = "testing";

    @BeforeClass
    public void connectDatabase() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to MySQL Database...");

        con = DriverManager.getConnection(databaseURL, user, password);
        stmt = con.createStatement();

        System.out.println("Database Connected Successfully.\n");
    }

    @Test(priority = 1)
    public void insertBookDetails() throws SQLException {

        String query = "DELETE FROM book_detl WHERE book_no = 'BI001'";
        
        stmt.execute(query);
        
        con.close();
        System.out.println("Statement Executed : Record Updated Successfully");
 }
}
