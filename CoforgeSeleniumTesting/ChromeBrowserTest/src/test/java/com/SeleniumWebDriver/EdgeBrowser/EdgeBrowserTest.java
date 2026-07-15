package com.SeleniumWebDriver.EdgeBrowser;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserTest {
	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/");
		driver.manage().window().maximize();
	}
}
