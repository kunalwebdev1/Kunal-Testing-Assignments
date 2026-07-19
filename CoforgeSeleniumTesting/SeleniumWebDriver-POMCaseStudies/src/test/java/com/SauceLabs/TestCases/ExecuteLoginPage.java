package com.SauceLabs.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SauceLabs.Pages.LoginSauceLabs;

import Helper.BrowserFactory;

public class ExecuteLoginPage {
	@Test
	public void CheckValidUser() {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "https://accounts.saucelabs.com/am/XUI/#login/");
		LoginSauceLabs loginPageSauceLabs = PageFactory.initElements(driver, LoginSauceLabs.class);
		loginPageSauceLabs.login_EasyCal("kunalmaheshwari97283@gmail.com", "mXqR4wU@gLLBs@f");
	}
}
