package com.SeleniumWebDriver.LocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class IDNameXpath {
	WebDriver driver;
	String baseURL = "https://practicetestautomation.com/practice-test-login/";
	
	public void IDLocator() {
		driver = new ChromeDriver();
		driver.navigate().to(baseURL);
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String title = driver.getTitle();
		WebElement heading = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1"));
		String headingText = heading.getText();
		if(title.equalsIgnoreCase(headingText)) {
			System.out.println("Passed...\nExpected Value: " + title +"\nActual Value: "+ headingText);
		} else {
			System.out.println("Failed...\nExpected Value: " + title + "\nActual Value: " + headingText);
		}
		Assert.assertEquals(driver.getTitle(), headingText);
//		driver.findElement(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).click();
	}
}
