package com.CSVFileReading;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class CSVFileReading {
	String csvPath = "/SeleniumWebDriverDataDrivenTesting-UsingCSVFile/CSVFileReading/File.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://only-testing-blog.blogspot.com/2014/05/form.html");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
