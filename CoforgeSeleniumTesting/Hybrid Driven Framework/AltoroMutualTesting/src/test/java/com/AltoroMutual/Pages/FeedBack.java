package com.AltoroMutual.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedBack {
WebDriver driver;
	
	public FeedBack(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (xpath = "//input[@name='name']")
	WebElement name;
	
	@FindBy (xpath = "//input[@name='email_addr']")
	WebElement email;
	
	@FindBy (xpath = "//input[@name='subject']")
	WebElement subject;
	
	@FindBy (xpath = "//textarea[@name='comments']")
	WebElement body;
	
	@FindBy (xpath = "//input[@name='reset']")
	WebElement reset;
	
	@FindBy (xpath = "//input[@name='submit']")
	WebElement submit;
	
	public void fill(String uname, String uemail, String usubject, String ubody) {
		name.sendKeys(uname);
		email.sendKeys(uemail);
		subject.sendKeys(usubject);
		body.sendKeys(ubody);
	}
	
	public void resetContent() {
		reset.click();
	}
	
	public void submitContent() {
		submit.click();
	}
	
	public void exit() {
		driver.quit();
	}
}
