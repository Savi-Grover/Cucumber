package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.PartialSignup.ParitalSignuppage;
import com.ford.auto.PartialSignup.SignInlinkPage;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PratialSignup extends Browser {

	ParitalSignuppage signuppage;

	SignInlinkPage signinlink;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("create user accounts with invaild details as following {string},{string},{string},{string},{string}")
	public void create_user_accounts_with_invaild_details_as_following(String firstname, String lastname, String email,
			String phoneno, String zipcode) throws InterruptedException {

		signuppage = new ParitalSignuppage(driver);

		signuppage.paritalSignupagevalidation(firstname, lastname, email, phoneno, zipcode);

	}

	@When("User clicks on the Get Strated")
	public void user_clicks_on_the_get_strated() throws InterruptedException {

		signuppage.userclicksGetstartedbtn();

	}

	@Then("error should be displayed")
	public void error_should_be_displayed() {

		signuppage.Validateerrormsg();

	}

	@Given("user click on signin link")
	public void user_click_on_signin_link() throws InterruptedException {
		signinlink = new SignInlinkPage(driver);

		signinlink.LoginwithSignInLink();

	}

	@Given("user lands on signin page")
	public void user_lands_on_signin_page() {

		signinlink.verifypagetitle();
	}

	@When("user enter email and password")
	public void user_enter_email_and_password() throws InterruptedException {

		signinlink.LogintoDashboard();

	}

	@Then("user succesfully login")
	public void user_succesfully_login() throws InterruptedException {

		signinlink.verifyDashboardpage();

	}
	
	@Given("the user is on the Partial Profile page")
	public void the_user_is_on_the_partial_profile_page() throws InterruptedException {
		
		signuppage = new ParitalSignuppage(driver);
		
		//signuppage.verifyPartialprofilepage();
	    
	}
	
	@Given("the user has not completed all required fields {string},{string},{string},{string},{string}")
	public void the_user_has_not_completed_all_required_fields(String firstname, String lastname, String email, String phoneno,
			String zipcode) throws InterruptedException {
		
		signuppage.paritalSignupagevalidation(firstname, lastname, email, phoneno, zipcode);
	}



	@When("the user views the Get Started button")
	public void the_user_views_the_get_started_button() throws InterruptedException {
		
		//signuppage.userclicksGetstartedbtn();
	}
	@Then("the Get Started button should be disabled")
	public void the_get_started_button_should_be_disabled() throws InterruptedException {
		
		signuppage.VerifyGetStartedButtonState();
	}
	
	//Validate new driver consent checkboxes
	



	
	


}
