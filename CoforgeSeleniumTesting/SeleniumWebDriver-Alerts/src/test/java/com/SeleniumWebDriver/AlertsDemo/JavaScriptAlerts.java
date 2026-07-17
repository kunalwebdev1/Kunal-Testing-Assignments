package com.SeleniumWebDriver.AlertsDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Utility.Helper;

public class JavaScriptAlerts {
	@Test
	public void TestPopups() throws Exception {
		WebDriver driver = Helper.startBrowsing("ff");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(4000);
		alert.accept();
		String result = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result);
		Assert.assertEquals("You successfully clicked an alert", result);
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(4000);
		alert2.dismiss();
		String result2 = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result2);
		Assert.assertEquals("You clicked: Cancel", result2);
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(4000);
		alert3.accept();
		String result3 = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result3);
		Assert.assertEquals("You clicked: Ok", result3);
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		driver.switchTo().alert().sendKeys("Hello Kunal Maheshwari");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		String result4 = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result4);
		Assert.assertEquals("You entered: Hello Kunal Maheshwari", result4);
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String result5 = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		Thread.sleep(4000);
		System.out.println(result5);
		Assert.assertEquals("Congratulations! You must have the proper credentials.", result5);
		
		driver.quit();
	}
}
