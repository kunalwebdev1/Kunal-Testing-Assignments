package com.PracticeTA.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.PracticeTA.Pages.LoginPTA;

import Helper.BrowserFactory;

public class ExecuteLogin {
	@Test
	public void CheckValidUser() {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "https://practicetestautomation.com/practice-test-login/");
		LoginPTA login_PTA = PageFactory.initElements(driver, LoginPTA.class);
		login_PTA.loginPTA("student", "Password123");
	}
}
