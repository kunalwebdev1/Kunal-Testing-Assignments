package com.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (how = How.ID, using = "log_email")
	WebElement Username;
	
	@FindBy (how = How.NAME, using = "log_password")
	WebElement Password;
	
	@FindBy (how = How.XPATH, using = "//input[@name='log_submit']")
	WebElement BtnLogin;
	
	public void login(String Uname, String Pass) {
		Username.sendKeys(Uname);
		Password.sendKeys(Pass);
		BtnLogin.click();
	}
}
