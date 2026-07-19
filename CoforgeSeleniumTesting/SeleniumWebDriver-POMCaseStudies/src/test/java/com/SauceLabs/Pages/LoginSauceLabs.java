package com.SauceLabs.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSauceLabs {
WebDriver driver;
	
	public LoginSauceLabs(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (xpath = "//input[id='idToken1']")
	WebElement email;
	
	@FindBy (xpath = "//input[id='idToken2']")
	WebElement password;
	
	@FindBy (xpath = "//input[id='loginButton_0']")
	WebElement loginbtn;
	
	public void login_EasyCal(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
	}
}
