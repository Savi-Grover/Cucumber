package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.FooterLinksPages;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterLinks extends Browser {

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("I am on the webpage")
	public void i_am_on_the_webpage() {

		// verify the page title

	}

	@When("I navigate to the footer section")
	public void i_navigate_to_the_footer_section() {

		// verify user navigate to the footer link

	}

	@Then("I should see multiple footer links")
	public void i_should_see_multiple_footer_links() {

		FooterLinksPages nooflinks = new FooterLinksPages(driver);

		nooflinks.verifyFooterLinks();

	}

}
