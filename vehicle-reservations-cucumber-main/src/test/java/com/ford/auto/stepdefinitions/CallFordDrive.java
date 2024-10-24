package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.callforddrive.CallFordDrivePages;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CallFordDrive extends Browser {
	
	CallFordDrivePages  clicksignin;
	
	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	

	@Given("user login with existing account to signin {string} and {string}")
	public void user_login_with_existing_account_to_signin_and(String existingemailId, String password) throws InterruptedException {
		
		
		  clicksignin = new CallFordDrivePages(driver);
		  
		  clicksignin.clickOnSignInLink();
		  
		  clicksignin.LogintoDashboard(existingemailId, password);
		
}
	
	
	
	@Given("user lands on the dashboard page with Pickup Pending status")
	public void user_lands_on_the_dashboard_page_with_pickup_pending_status() throws InterruptedException {
		
		clicksignin.newdriverlandsonthe_dashboardpage();
	    
	}
	
	
	
	@Given("user clicks on the Schedule your pickup section dropdown Arrow")
	public void user_clicks_on_the_schedule_your_pickup_section_dropdown_arrow() throws InterruptedException {
		
	   //user clicks on the Schedule your pickup section dropdown Arrow
	}
	
	
	@When("user clicks on the Call customer care option")
	public void user_clicks_on_the_call_customer_care_option() {
		
		//user clicks on the Call customer care option
	    
	}
	
	@Then("user should be able to contact Customer care successfully")
	public void user_should_be_able_to_contact_customer_care_successfully() throws InterruptedException {
		 clicksignin.clicksontheSchedulePickup();
	}




}
