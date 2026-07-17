package com.WebElementsCaseStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EasyCalculationsDemo1 {
	@Test
	public void clearMethodDemo() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.easycalculation.com/most-searched.php");

        driver.findElement(By.xpath("//a[normalize-space()='BMI Calculator']")).click();

        WebElement height = driver.findElement(By.xpath("//input[@name='wg']"));

        WebElement weight = driver.findElement(By.xpath("//input[@name='ht']"));
        
        height.clear();
        weight.clear();

        height.sendKeys("170");
        weight.sendKeys("70");

        Thread.sleep(2000);

        height.clear();
        weight.clear();

        Thread.sleep(2000);

        driver.quit();
	}
}