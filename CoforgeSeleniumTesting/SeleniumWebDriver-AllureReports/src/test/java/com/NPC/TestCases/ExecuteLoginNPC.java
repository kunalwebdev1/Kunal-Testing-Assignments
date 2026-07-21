package com.NPC.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.NPC.Pages.LoginNPC;

import Helper.BrowserFactory;

public class ExecuteLoginNPC {
	@Test
	public void CheckValidUser() throws Exception {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "https://www.nopcommerce.com/en/login");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id=\"KSUV2\"]/div/label/span[2]")).click();
		LoginNPC login = PageFactory.initElements(driver, LoginNPC.class);
		login.login_NPC("student", "Password123");
	}

}
