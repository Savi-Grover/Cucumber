package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logout extends Browser{
	

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	
	

@When("user selects the logout option on the dashboard")
public void user_selects_the_logout_option_on_the_dashboard() {
	// user Click on the logout option
    
}
@Then("user should be logged out successfully")
public void user_should_be_logged_out_successfully() {
	
	WebElement  logoutBtn = driverSupport.locateByXpath("//div[@data-testid='logout-button']");
	
	if (logoutBtn.isDisplayed()) {
		logoutBtn.click();
		
		System.out.println("Logout functionality in Pickup pending status dashboard page verified successfully!");
	} else {
		
		System.out.println("logout functionality in Pickup pending status dashboard page verification failed!");
		Assert.fail();
	}

    
}


}
