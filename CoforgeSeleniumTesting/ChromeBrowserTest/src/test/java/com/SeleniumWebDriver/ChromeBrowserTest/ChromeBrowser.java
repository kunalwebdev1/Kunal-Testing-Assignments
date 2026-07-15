package com.SeleniumWebDriver.ChromeBrowserTest;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");	
		
		driver.manage().window().maximize();
				
		driver.manage().window().minimize();
		System.out.println("Title: " + driver.getTitle());
	}
}
