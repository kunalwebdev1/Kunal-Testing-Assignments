package com.SeleniumWebDriver.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/");
		driver.manage().window().maximize();
	}
}
