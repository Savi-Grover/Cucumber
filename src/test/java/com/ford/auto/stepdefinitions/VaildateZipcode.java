package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.PartialSignup.ValidateZipcodePage;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VaildateZipcode extends Browser {

	ValidateZipcodePage vaildzipcode;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("a new driver has registered with his info {string},{string},{string},{string},{string}")
	public void a_new_driver_has_registered_with_his_info(String firstname, String lastname, String email,
			String phoneno, String zipcode) throws InterruptedException {
		vaildzipcode = new ValidateZipcodePage(driver);

		vaildzipcode.paritalSignupagevalidation(firstname, lastname, email, phoneno, zipcode);

		vaildzipcode.userclicksGetstartedbtn();

		vaildzipcode.OtpPage();

	}

	@When("user Provided valid Garaging Zipcodes")
	public void user_provided_valid_garaging_zipcodes() {

		// user Provided valid Garaging Zipcodes

	}

	@Then("Package Selection should be displayed")
	public void package_selection_should_be_displayed() throws InterruptedException {
		
		vaildzipcode = new ValidateZipcodePage(driver);
		
		vaildzipcode.VaildZipcode();

	}
	
	@When("the user enters an invalid Zipcode")
	public void the_user_enters_an_invalid_zipcode() {
		//the user enters an invalid Zipcode
	    
	}
	@Then("an error message should be displayed indicating that the Zipcode is invalid")
	public void an_error_message_should_be_displayed_indicating_that_the_zipcode_is_invalid(){
		
		vaildzipcode = new ValidateZipcodePage(driver);
		
		vaildzipcode.ValidateZipcodeErrormsg();
		
		
	    
	}

}
