package com.SeleniumWebDriver.LocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassNameTestDemo {
	
	
	@Test
	public void ClassNameTest() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/");
		Thread.sleep(10000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Cookies popup not displayed.");
		}
		
		driver.findElement(By.xpath("//img[@alt='Vitamin Drinks category product example']")).click();
		driver.findElement(By.className("ProductCardImage-module_picture__QWY9P")).click();
		
		String BrowserTitle = driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().back();
		BrowserTitle = driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().refresh();
		BrowserTitle = driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().forward();
		BrowserTitle = driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.quit();
	}
}