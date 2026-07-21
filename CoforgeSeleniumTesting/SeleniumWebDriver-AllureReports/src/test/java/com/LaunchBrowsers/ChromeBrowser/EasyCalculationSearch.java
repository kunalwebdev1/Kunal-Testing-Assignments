package com.LaunchBrowsers.ChromeBrowser;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EasyCalculationSearch {

	@Test

	public void search() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.easycalculation.com");

		driver.findElement(By.id("s")).sendKeys("Bangalore");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(driver.getTitle());

		System.out.println(driver.getPageSource().length());

		driver.quit();

	}

}
