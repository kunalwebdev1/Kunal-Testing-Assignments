package com.NPC.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginNPC {
WebDriver driver;
	
	public LoginNPC(WebDriver driver) {
		this.driver = driver;
	}	
	@FindBy (xpath = "//input[@id='Username']")
	WebElement email;
	
	@FindBy (xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy (xpath = "//input[@value='Log in']")
	WebElement loginbtn;
	
	public void login_NPC(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
	}
}
