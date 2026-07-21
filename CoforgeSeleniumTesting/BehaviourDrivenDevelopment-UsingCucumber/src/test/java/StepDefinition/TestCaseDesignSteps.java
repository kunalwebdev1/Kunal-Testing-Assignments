package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class TestCaseDesignSteps {
	WebDriver driver;
	String url = "https://practicetestautomation.com/practice-test-login/";
	
	@Given("User Should Open Chrome Browser")
	public void user_should_open_chrome_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@When("User Should Enter Url in Browser")
	public void user_should_enter_url_in_browser() {
	    driver.get(url);
	}

	@When("User Should Navigate HomePage")
	public void user_should_navigate_home_page() {
	    String HomePage = driver.getTitle();
	    System.out.println(HomePage);
	}

	@When("Enter UserName and Password in Edit Box")
	public void enter_user_name_and_password_in_edit_box() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
	}

	@When("Click on Login PushButton")
	public void click_on_login_push_button() {
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
	    String msg = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
	    if(msg.equals("Logged In Successfully")) {
	    	System.out.println("Passed");
	    } else {
	    	System.out.println("Failed");
	    }
	}

}
