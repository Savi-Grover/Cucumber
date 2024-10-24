package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.TermsConditionsPages;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TermsandConditions extends Browser {
	TermsConditionsPages tac;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	
	
	@When("the user clicks on the Terms and Conditions link")
	public void the_user_clicks_on_the_terms_and_conditions_link() throws InterruptedException {
      tac = new TermsConditionsPages(driver);
		
		tac.clickonTaclink(); 
	}
	
	@Then("the user should be redirected to the Terms and Conditions page")
	public void the_user_should_be_redirected_to_the_terms_and_conditions_page() throws InterruptedException {
		
	    tac.verifyTermsConditionlink();
	}



	
	
	


}
