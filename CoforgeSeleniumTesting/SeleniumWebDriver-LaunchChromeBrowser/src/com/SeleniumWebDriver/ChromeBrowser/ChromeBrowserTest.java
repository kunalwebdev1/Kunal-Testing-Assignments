package com.SeleniumWebDriver.ChromeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.glbajajgroup.org");

		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());

		System.out.println("URL: " + driver.getCurrentUrl());
		
		driver.quit();
	}
}