package com.JDBC.Connection;

import java.sql.*;
import org.testng.annotations.*;

public class DBTestAll {

    Connection con;
    Statement stmt;

    String databaseURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";
    String user = "root";
    String password = "testing";

    @BeforeClass
    public void connectDatabase() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("======================================");
        System.out.println("Connecting to MySQL Database...");
        System.out.println("======================================");

        con = DriverManager.getConnection(databaseURL, user, password);
        stmt = con.createStatement();

        System.out.println("Database Connected Successfully.\n");
    }

    @Test(priority = 1)
    public void displayBookDetails() throws SQLException {

        System.out.println("\n========== BOOK_DETL TABLE ==========\n");

        String query = "SELECT * FROM book_detl";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            System.out.println(
                    "Book No : " + rs.getString("book_no")
                            + " | Title : " + rs.getString("title")
                            + " | Subject : " + rs.getString("sub_code")
                            + " | Author : " + rs.getString("author")
                            + " | Publisher : " + rs.getString("publisher")
                            + " | Status : " + rs.getString("status")
                            + " | Year : " + rs.getString("yop")
                            + " | Price : " + rs.getInt("price"));
        }

        rs.close();
    }

    @Test(priority = 2)
    public void displayCustomerDetails() throws SQLException {

        System.out.println("\n========== CUST_NEW TABLE ==========\n");

        String query = "SELECT * FROM cust_new";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            System.out.println(
                    "Customer ID : " + rs.getInt("CUSTOMER_ID")
                            + " | Last Name : " + rs.getString("CUST_LAST_NAME")
                            + " | DOB : " + rs.getString("DATE_OF_BIRTH")
                            + " | Manager ID : " + rs.getInt("ACCOUNT_MGR_ID"));
        }

        rs.close();
    }

    @Test(priority = 3)
    public void displayOrderDetails() throws SQLException {

        System.out.println("\n========== ORDER_NEW TABLE ==========\n");

        String query = "SELECT * FROM order_new";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            System.out.println(
                    "Order ID : " + rs.getInt("ORDER_ID")
                            + " | Order Date : " + rs.getString("ORDER_DATE")
                            + " | Order Mode : " + rs.getString("ORDER_MODE")
                            + " | Customer ID : " + rs.getInt("CUSTOMER_ID")
                            + " | Order Total : " + rs.getDouble("ORDER_TOTAL"));
        }

        rs.close();
    }

    @Test(priority = 4)
    public void displayStudentDetails() throws SQLException {

        System.out.println("\n========== STU_DETL TABLE ==========\n");

        String query = "SELECT * FROM stu_detl";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            System.out.println(
                    "Student Code : " + rs.getString("stu_code")
                            + " | Name : " + rs.getString("name")
                            + " | Department : " + rs.getString("dept_code")
                            + " | Fine : " + rs.getString("fine"));
        }

        rs.close();
    }

    @AfterClass
    public void closeDatabase() throws SQLException {

        if (stmt != null)
            stmt.close();

        if (con != null)
            con.close();

        System.out.println("\n======================================");
        System.out.println("Database Connection Closed.");
        System.out.println("======================================");
    }

}
