package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.PrivacyChoicesPage;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrivacyChoices extends Browser {

	PrivacyChoicesPage pcpage;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	

	@When("the user clicks on the Your Privacy Choices link")
	public void the_user_clicks_on_the_your_privacy_choices_link() throws InterruptedException {
	    pcpage = new PrivacyChoicesPage(driver);

	    pcpage.clickPrivacyChoicePageLink();
	}

	@Then("the user should be directed to the privacy choices page")
	public void the_user_should_be_directed_to_the_privacy_choices_page() throws InterruptedException {

		pcpage.verifyPrivacyChoicelink();

	}

}
