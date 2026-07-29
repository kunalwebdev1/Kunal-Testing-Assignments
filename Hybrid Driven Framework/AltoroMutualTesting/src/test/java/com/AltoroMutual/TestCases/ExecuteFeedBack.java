package com.AltoroMutual.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.AltoroMutual.Pages.FeedBack;

import Helper.BrowserFactory;
import Helper.Reusability;

public class ExecuteFeedBack {
	@Test
	public void Feedback() throws Exception {
		WebDriver driver = BrowserFactory.BrowserOptions("firefox", "http://altoro.testfire.net/feedback.jsp");
		Reusability.capturedScreenShot(driver, "f1");
		FeedBack fb = PageFactory.initElements(driver, FeedBack.class);
		fb.fill("Kunal", "kunal.webdev1@gmail.com", "Regarding Account Opening", "Hi, I want to get the details about account opening in your bank account.");
		Reusability.capturedScreenShot(driver, "f2");
		Thread.sleep(5000);
		fb.resetContent();
		Reusability.capturedScreenShot(driver, "f3");
		fb.fill("Kunal", "kunal.webdev1@gmail.com", "Regarding Account Opening", "Hi, I want to get the details about account opening in your bank account.");
		Reusability.capturedScreenShot(driver, "f4");
		Thread.sleep(5000);
		fb.submitContent();
		Reusability.capturedScreenShot(driver, "f5");
		fb.exit();
	}
}
