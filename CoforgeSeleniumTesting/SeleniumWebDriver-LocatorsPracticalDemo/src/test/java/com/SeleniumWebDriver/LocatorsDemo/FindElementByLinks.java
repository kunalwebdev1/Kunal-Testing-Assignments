package com.SeleniumWebDriver.LocatorsDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FindElementByLinks {
	WebDriver driver;
	int Total = 0;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/");
		Thread.sleep(10000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Cookies popup not displayed.");
		}
	}
	
	@Test
	public void findElementById() {
		driver.findElement(By.xpath("//img[@alt='Vitamin Drinks category product example']")).click();
		driver.findElement(By.linkText("Home")).click();
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int linkCount = links.size();
		Total = Total + links.size();
		System.out.println("Number of Links: " + linkCount);
		for(int i = 1; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
		driver.quit();
	}
}
