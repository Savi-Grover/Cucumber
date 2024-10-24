package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.createpasswordpage.createpasswordpages;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreatePasswordButton extends Browser {

	createpasswordpages passwordfield;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	//Verify create password button is disabled when password and confirm password do not match

	@Given("new driver sets the password {string}")
	public void new_driver_sets_the_password(String enterpassword) throws InterruptedException {

		passwordfield = new createpasswordpages(driver);

		passwordfield.Passwordfield(enterpassword);

	}

	@Given("new driver sets different confirm password {string}")
	public void new_driver_sets_different_confirm_password(String enterconfirmpassword) throws InterruptedException {

		passwordfield.confirmPasswordfield(enterconfirmpassword);

	}

	@Then("Create password button should be disabled until password and confirm password match")
	public void create_password_button_should_be_disabled_until_password_and_confirm_password_match()
			throws InterruptedException {

		passwordfield.VerifycreatepasswordButton();
	}
	
	//Verify create password button is disabled when password and confirm password does not entered

	@Given("new driver not set password in confirm password {string}")
	public void new_driver_not_set_password_in_confirm_password(String confirmpasswordnotset) throws InterruptedException {
		
		passwordfield.confirmPasswordfield(confirmpasswordnotset);
		
	    
	}
	
	//Verify create password button is disabled when password not entered and confirm password entered in Congrats page
	
	@Given("new driver not sets the password {string}")
	public void new_driver_not_sets_the_password(String passwordnotset) throws InterruptedException {
		
		passwordfield.Passwordfield(passwordnotset);

	    
	}






}
