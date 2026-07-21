package com.WebDriverCommands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Test
public class BrowserCommands {
	public void ChromeBrowserTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		String ExpectedTitle = "Test Login | Practice Test Automation";
		
		String BrowserTitle = driver.getTitle();
		System.out.println("Title: "+BrowserTitle);
		
		String BrowserURL = driver.getCurrentUrl();
		System.out.println("URL: "+BrowserURL);
		
		String ExpectedURL = "https://practicetestautomation.com/practice-test-login/";
		
		if (ExpectedURL.equals(BrowserURL)) {
			System.out.println("Chrome Browser Passed, Expected URL: " + ExpectedURL + " Does matches Actual URL: " + BrowserURL);
		} else {
			System.out.println("Chrome Browser Failed, Expected URL: " + ExpectedURL + " Does not matches Actual URL: " + BrowserURL);
		}
		
		if (ExpectedTitle.equals(BrowserTitle)) {
			System.out.println("Chrome Browser Passed, Expected Title: " + ExpectedTitle + " Does matches Actual Title: " + BrowserTitle);
		} else {
			System.out.println("Chrome Browser Failed, Expected Title: " + ExpectedTitle + " Does not matches Actual Title: " + BrowserTitle);
		}
		
		
		/* String PageContent = driver.getPageSource();
		System.out.println("Page Content: " + PageContent); */
		
		
		
		
		driver.quit();
	}
	
	public void FirefoxBrowserTest() {
		FirefoxDriver driver = new FirefoxDriver();
		
		String ExpectedTitle = "Selenium";
		
		driver.get("https://selenium.dev/");
		driver.manage().window().maximize();
		String BrowserTitle = driver.getTitle();
		System.out.println("Title: "+BrowserTitle);
		
		String BrowserURL = driver.getCurrentUrl();
		System.out.println("URL: "+BrowserURL);
		
		if (ExpectedTitle.equals(BrowserTitle)) {
			System.out.println("Firefox Browser Passed, Expected Title: " + ExpectedTitle + " Does matches Actual Title: " + BrowserTitle);
		} else {
			System.out.println("Firefox Browser Failed, Expected Title: " + ExpectedTitle + " Does not matches Actual Title: " + BrowserTitle);
		}
		
		driver.quit();
	}
	
	public void EdgeBrowserTest() {
		EdgeDriver driver = new EdgeDriver();
		
		String ExpectedTitle = "Maven Repository: Search/Browse/Explore";
		
		driver.get("https://mvnrepository.com/");
		driver.manage().window().maximize();
		String BrowserTitle = driver.getTitle();
		System.out.println("Title: "+BrowserTitle);
		
		String BrowserURL = driver.getCurrentUrl();
		System.out.println("URL: "+BrowserURL);
		
		if (ExpectedTitle.equals(BrowserTitle)) {
			System.out.println("Edge Browser Passed, Expected Title: " + ExpectedTitle + " Does matches Actual Title: " + BrowserTitle);
		} else {
			System.out.println("Edge Browser Failed, Expected Title: " + ExpectedTitle + " Does not matches Actual Title: " + BrowserTitle);
		}
		
		driver.quit();
	}
}