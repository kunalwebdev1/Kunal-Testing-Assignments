package com.Framework.TestCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Framework.Pages.BaseClass;
import com.Framework.Pages.LoginPage;

import utility.ExcelDataReader;

public class LoginOrganHRM extends BaseClass {
	@Test
	public void loginApp() throws Exception {
		ExcelDataReader excel = new ExcelDataReader();
		excel.getStringData("LoginHRM", 0, 0);
		LoginPage loginHRM = PageFactory.initElements(driver, LoginPage.class);
		loginHRM.login(excel.getStringData("LoginHRM", 0, 0), excel.getStringData("LoginHRM", 0, 1));
		Thread.sleep(10000);
	}
}
