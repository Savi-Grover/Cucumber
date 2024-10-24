package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.FAQlinkPages;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FAQLink extends Browser {

	FAQlinkPages faq;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	@Given("Iam on the OTP Page")
	public void iam_on_the_otp_page() {
	    //Iam on the OTP Page 
	}

	@When("I click on the FAQ footer link")
	public void i_click_on_the_faq_footer_link() throws InterruptedException {

		faq = new FAQlinkPages(driver);

		faq.verifyFAQlink();

	}
	
	
	@Then("the FAQ page should open in different tab")
	public void the_faq_page_should_open_in_different_tab() throws InterruptedException {
		faq.verifyFAQTitle();
	    
	}







	

}
