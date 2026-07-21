package com.MultipleFrames.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver driver;
	String url = "C:\\MultipleFrames\\iframe.html";
	
	@Test
	public void IFrame() throws Exception {
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		int totalnoofframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frames: " + totalnoofframes);
		
		driver.switchTo().frame("easycalculation");
		driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");
		driver.findElement(By.id("log_email")).sendKeys("9740673180");
		driver.findElement(By.id("log_password")).sendKeys("raghubn@123");
		driver.findElement(By.name("log_submit")).click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.navigate().to(url);
		driver.findElement(By.xpath("/html/body/a")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Documentation']")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		driver.navigate().to(url);
		driver.switchTo().frame("My Store");
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.quit();
	}
}
