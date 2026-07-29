package com.AltoroMutual.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.AltoroMutual.Pages.LoginAM;

import Helper.BrowserFactory;
import Helper.Reusability;

public class ExecuteAMLogin {
	@Test
	public void CheckValidUser() {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "http://altoro.testfire.net/login.jsp");
		Reusability.capturedScreenShot(driver, "task1");
		LoginAM login_AM = PageFactory.initElements(driver, LoginAM.class);
		login_AM.login_AM("jsmith", "demo1234");
		Reusability.capturedScreenShot(driver, "task1");
		login_AM.exit();
	}
}
