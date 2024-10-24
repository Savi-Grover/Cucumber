package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.consentcheckboxpages.ConsentCheckboxPages;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConsentCheckBox extends Browser {

	ConsentCheckboxPages checkbox;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("the new driver is on the consent checkbox page {string},{string},{string},{string},{string}")
	public void the_new_driver_is_on_the_consent_checkbox_page(String firstname, String lastname, String email,
			String phoneno, String zipcode) throws InterruptedException {

		checkbox = new ConsentCheckboxPages(driver);

		checkbox.verifyPartialprofilepage();

		checkbox.newUserOnSignupage(firstname, lastname, email, phoneno, zipcode);

	}

	@When("the new driver clicks on the I accept checkbox")
	public void the_new_driver_clicks_on_the_i_accept_checkbox() throws InterruptedException {
		checkbox.userclicksConsentCheckbox();
	}

	@Then("the checkbox should be checked")
	public void the_checkbox_should_be_checked() {
		// the checkbox should be checked
	}

	@Then("the new driver should be able to proceed to the next page")
	public void the_new_driver_should_be_able_to_proceed_to_the_next_page() {
		// the new driver should be able to proceed to the next page
	}

}
