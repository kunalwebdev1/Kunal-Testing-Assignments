package com.WebElementsCaseStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EasyCalculationsDemo2 {
	@Test
	public void verifySearchBox() {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.easycalculation.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='googleSearchId']"));

        if(searchBox.isDisplayed()) {
            System.out.println("Search Text Box is Displayed");
        }
        else {
            System.out.println("Search Text Box is NOT Displayed");
        }

        driver.quit();
    }
}
