package com.RadioButtons.TestExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonsTest {
	@Test
	public void spiceJet() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		driver.findElement(By.xpath("(//*[name()='circle'])[6]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[name()='circle'])[3]")).click();
		Thread.sleep(5000);
		
		List<WebElement> circleElements = driver.findElements(By.xpath("//*[name()='circle']"));
		
		System.out.println("=== RADIO BUTTONS ===");
		for(int i = 0; i < circleElements.size(); i++) {
			WebElement element = circleElements.get(i);
			System.out.println("Button " + (i+1) + ": ");
			System.out.println("  - Tag: " + element.getTagName());
			System.out.println("  - Displayed: " + element.isDisplayed());
			System.out.println("  - Enabled: " + element.isEnabled());
			System.out.println("  - Class: " + element.getAttribute("class"));
			System.out.println("  - Aria-checked: " + element.getAttribute("aria-checked"));
			System.out.println("------------------------------------------");
			
		}
		driver.quit();
	}
}
