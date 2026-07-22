package com.CRUDOperations.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InsertValueDemo {

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

        String query =
                "INSERT INTO book_detl (book_no, title, sub_code, author, publisher, status, yop, price) VALUES " +
                "('JP001','Java Phantom','Jav','Kunal','MPublishers','S','2026',5900)," +
                "('JP002','Core Java','Jav','James Gosling','Oracle','S','2023',850)," +
                "('JP003','Advanced Java','Jav','Herbert Schildt','McGraw','S','2022',1200)," +
                "('PY001','Python Basics','Py','Guido','TechBooks','S','2021',700)," +
                "('PY002','Python Master','Py','Rossum','TechBooks','S','2024',950)," +
                "('DB001','MySQL Guide','DB','Michael','DBHouse','S','2020',600)," +
                "('DB002','SQL Master','DB','John Smith','DBHouse','S','2019',750)," +
                "('SE001','Selenium WebDriver','Tes','Simon Stewart','AutomationPub','S','2025',1500)," +
                "('SE002','TestNG Complete','Tes','Cedric Beust','AutomationPub','S','2024',999)," +
                "('CU001','Cucumber BDD','Tes','Aslak Hellesoy','AutomationPub','S','2025',1300)";

        int rows = stmt.executeUpdate(query);

        System.out.println(rows + " rows inserted successfully.");
    }
}