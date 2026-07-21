package com.AltoroMutual.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAM {
WebDriver driver;
	
	public LoginAM(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (xpath = "//input[@id='uid']")
	WebElement email;
	
	@FindBy (xpath = "//input[@id='passw']")
	WebElement password;
	
	@FindBy (xpath = "//input[@name='btnSubmit']")
	WebElement loginbtn;
	
	public void login_AM(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
	}
}
