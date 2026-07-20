package com.CSVFileReading;

import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import au.com.bytecode.opencsv.CSVReader;

public class CSVFileReading {
	String csvPath = "C:/Users/kunal/OneDrive/Documents/CSVFileReading/File.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://only-testing-blog.blogspot.com/2014/05/form.html");
	}
	
	@Test
	public void DDTTestingBlog() throws Exception {
		CSVReader reader = new CSVReader(new FileReader(csvPath));
		String[] csvCell;
		while((csvCell = reader.readNext()) != null) {
			String FName = csvCell[0];
			String LName = csvCell[1];
			String Email = csvCell[2];
			String MNumb = csvCell[3];
			String CName = csvCell[4];
			driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FName);
			driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LName);
			driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys(MNumb);
			driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(CName);
			
			Thread.sleep(8000);
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(8000);
			driver.switchTo().alert().accept();
		}
		reader.close();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
