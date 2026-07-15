package com.NavigationCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BrowserNavigationCaseStudy {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
    }

    @Test
    public void NavigationTest() throws Exception {

        String homeURL = "https://practicetestautomation.com/practice-test-login/";

        driver.get(homeURL);
        System.out.println("Home Page Opened");
        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        driver.findElement(By.id("submit")).click();
        System.out.println("Login Successful");
        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println("Back Command");
        Thread.sleep(2000);

        driver.navigate().forward();
        System.out.println("Forward Command");
        Thread.sleep(2000);

        driver.navigate().to(homeURL);
        System.out.println("Navigate To Command");
        Thread.sleep(2000);

        driver.navigate().refresh();
        System.out.println("Refresh Command");
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
    }

    @AfterMethod
    public void tearDown() {
    	System.out.println("Quiting...");
        driver.quit();
    }
}