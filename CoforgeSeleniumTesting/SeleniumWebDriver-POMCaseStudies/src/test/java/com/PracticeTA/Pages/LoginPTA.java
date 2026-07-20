package com.PracticeTA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPTA {
WebDriver driver;
	
	public LoginPTA(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (xpath = "//input[@id='username']")
	WebElement email;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy (xpath = "//button[@id='submit']")
	WebElement loginbtn;
	
	public void loginPTA(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
	}
}
