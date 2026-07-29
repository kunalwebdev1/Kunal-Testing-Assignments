package com.AltoroMutual.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.AltoroMutual.Pages.ServerStatusCheck;

import Helper.BrowserFactory;
import Helper.Reusability;

public class ExecuteServerStatusCheck {
	@Test
	public void CheckServer() throws Exception {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "http://altoro.testfire.net/index.jsp");
		Reusability.capturedScreenShot(driver, "p1");
		ServerStatusCheck server = PageFactory.initElements(driver, ServerStatusCheck.class);
		server.status();
		Reusability.capturedScreenShot(driver, "p2");
		Thread.sleep(5000);
		server.statusClick();
		Thread.sleep(10000);
		Reusability.capturedScreenShot(driver, "p3");
		server.exit();
	}
}
