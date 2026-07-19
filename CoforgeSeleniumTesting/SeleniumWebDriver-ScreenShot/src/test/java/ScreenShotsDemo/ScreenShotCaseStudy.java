package ScreenShotsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Reusability;

public class ScreenShotCaseStudy {
	@Test
	public static void PurchaseProduct() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		Reusability.capturedScreenShot(driver, "Task 1");

		driver.get("https://auth.hollandandbarrett.com/u/login");
		driver.manage().window().maximize();
		Reusability.capturedScreenShot(driver, "Task 2");

		
		System.out.println("Title: " + driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kunal.webdev1@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("D@5@B-vm&5aJT@4");
		driver.findElement(By.xpath("//button[@name='action']")).click();
		Reusability.capturedScreenShot(driver, "Task 3");

		
		
		Thread.sleep(10000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Cookies popup not displayed.");
		}
		
		System.out.println("Searching Product: Vitamin A");
		driver.findElement(By.xpath("//input[@placeholder='Search products, brands, articles...']")).sendKeys("Vitamin A");
		driver.findElement(By.xpath("//div[@class='SearchBar-module_searchIconWrapper__pG491']//*[name()='svg']")).click();
		Reusability.capturedScreenShot(driver, "Task 4");

		System.out.println("Clicking on Product: Vitamin A");
		driver.findElement(By.xpath("//div[normalize-space()='Vitamin A 3330IU + Vit D & Cod Liver Oil 90 Capsules']")).click();
		Reusability.capturedScreenShot(driver, "Task 5");
		
		System.out.println("Adding to the Basket: Vitamin A Product");
		driver.findElement(By.xpath("//button[@id='add-to-basket-button']//span[@class='b_MR6OF'][normalize-space()='Add']")).click();
		Reusability.capturedScreenShot(driver, "Task 6");
		
		System.out.println("Checking the basket after adding Vitamin A Product");
		driver.findElement(By.xpath("//button[@class='b_gz48b b_2JabQ b_uxuIb b_eM50D HeaderPart-module_closeButton__6H2cX']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")).click();
		Reusability.capturedScreenShot(driver, "Task 7");
		
		System.out.println("Checking the basket after adding Vitamin A Product");
		driver.get("https://www.hollandandbarrett.com/basket");
		Reusability.capturedScreenShot(driver, "Task 8");
		
		driver.quit();
	}
}
