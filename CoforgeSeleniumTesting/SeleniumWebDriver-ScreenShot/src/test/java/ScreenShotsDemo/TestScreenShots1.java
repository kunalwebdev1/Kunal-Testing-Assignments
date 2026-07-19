package ScreenShotsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Reusability;

public class TestScreenShots1 {
	@Test
	public void Browser() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		Reusability.capturedScreenShot(driver, "A. Launch Application - TakeScreenShot");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		
		driver.findElement(By.id("submit")).click();
		
		Reusability.capturedScreenShot(driver, "B. Click Sign In Button - TakeScreenShot");
		
		driver.quit();
	}
}
