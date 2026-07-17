package com.SeleniumWebDriver.AlertsCaseStudy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Rediff {
	
	@Test
	public void rediffLoginTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//button[@name='proceed']")).click();
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		System.out.println(alertmsg);
        alert.accept();
        
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("abcd123321");
		driver.findElement(By.xpath("//button[@name='proceed']")).click(); 
        Alert alert1 = driver.switchTo().alert();
		String alertmsg1 = alert1.getText();
		System.out.println(alertmsg1);
        alert1.accept();
        
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("xyzkdoanca");
        driver.findElement(By.xpath("//button[@name='proceed']")).click();
	}
}
