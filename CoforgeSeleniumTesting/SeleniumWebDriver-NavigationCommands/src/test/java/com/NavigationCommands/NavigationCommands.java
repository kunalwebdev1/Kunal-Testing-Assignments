package com.NavigationCommands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NavigationCommands {
	@Test
	public void ChromeTest() {
		System.out.println("Chrome Test Starts");
		ChromeDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().to("https://www.google.com/");
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().back();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().forward();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
			
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().refresh();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		System.out.println("Chrome Test Ends");
	}
	
	@Test 
	public void EdgeTest() {
		EdgeDriver driver = new EdgeDriver();
		System.out.println("Edge Test Starts");
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().to("https://www.google.com/");
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().back();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().forward();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().refresh();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		System.out.println("Edge Test Ends");
		
	}
	
	@Test
	public void FirefoxTest() {
		FirefoxDriver driver = new FirefoxDriver();
		System.out.println("Firefox Test Starts");
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().to("https://www.google.com/");
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().back();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().forward();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.navigate().refresh();
		URL = driver.getCurrentUrl();
		System.out.println(URL);
		System.out.println("FireFox Test Ends");
	}
	
}
