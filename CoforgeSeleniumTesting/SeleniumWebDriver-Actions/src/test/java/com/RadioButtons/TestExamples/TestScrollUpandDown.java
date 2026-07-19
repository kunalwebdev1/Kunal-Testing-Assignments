package com.RadioButtons.TestExamples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScrollUpandDown {
	WebDriver driver;
	String url = "https://www.spicejet.com/";
	
	@Test
	public void Test() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1500);
		
		((JavascriptExecutor) driver).executeScript("scroll(0, 6600)");
		Thread.sleep(1500);
		((JavascriptExecutor) driver).executeScript("scroll(0, -4200)");
		
		driver.quit();
	}
}
