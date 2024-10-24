package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.VisitFordcomPage;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisitFordcom extends Browser {

	VisitFordcomPage fordcom;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	
	
	

@When("the user clicks on the VisitFord.com link")
	public void the_user_clicks_on_the_visit_ford_com_link() throws InterruptedException {

		fordcom = new VisitFordcomPage(driver);
		fordcom.clickonVisitFordcomPage();
	}


	@Then("the user should be redirected to the Visit Ford.com page")
	public void the_user_should_be_redirected_to_the_visit_ford_com_page() throws InterruptedException {

		fordcom.verifyVisitFordcomlink();

	}

}
