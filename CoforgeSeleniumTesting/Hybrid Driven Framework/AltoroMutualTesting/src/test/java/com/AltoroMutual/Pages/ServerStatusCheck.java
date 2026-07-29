package com.AltoroMutual.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerStatusCheck {
WebDriver driver;
	
	public ServerStatusCheck(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (xpath = "//div[@id='footer']//a[3]")
	WebElement statusCheckBtn;
	
	@FindBy (xpath = "//input[@value='Check Status']")
	WebElement statusClickBtn;
	
	public void status() {
		statusCheckBtn.click();
	}
	
	public void statusClick() {
		statusClickBtn.click();
	}
	public void exit() {
		driver.quit();
	}
}
