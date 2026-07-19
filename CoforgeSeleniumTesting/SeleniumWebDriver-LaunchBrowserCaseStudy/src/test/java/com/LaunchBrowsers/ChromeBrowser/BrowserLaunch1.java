package com.LaunchBrowsers.ChromeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserLaunch1 {

    @Test
    public void launchBrowser() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.login.hiox.com/register?referrer=easycalculation.com");

        System.out.println("Title : " + driver.getTitle());

        String source = driver.getPageSource();

        System.out.println("Page Source Length : " + source.length());

        driver.quit();
    }
}