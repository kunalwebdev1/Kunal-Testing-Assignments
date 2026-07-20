package com.AltoroMutual.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.AltoroMutual.Pages.LoginAM;

import Helper.BrowserFactory;

public class ExecuteLoginAM {
	@Test
	public void CheckValidUser() {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "http://altoro.testfire.net/login.jsp");
		LoginAM login_AM = PageFactory.initElements(driver, LoginAM.class);
		login_AM.login_AM("student", "Password123");
	}
}
