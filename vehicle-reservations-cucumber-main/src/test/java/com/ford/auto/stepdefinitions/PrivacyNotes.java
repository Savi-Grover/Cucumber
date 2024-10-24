package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.PrivacyChoicesPage;
import com.ford.auto.footerlinks.PrivacyNoticePage;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrivacyNotes extends Browser {
	PrivacyNoticePage pnpage;
	
	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	
	@When("the user clicks on the Privacy Notice link")
	public void the_user_clicks_on_the_privacy_notice_link() throws InterruptedException {
		
		pnpage = new PrivacyNoticePage(driver);
		
		pnpage.clickPrivacyNoticePageLink();
		
	    
	}
	@Then("the user should be redirected to the Privacy Notice page")
	public void the_user_should_be_redirected_to_the_privacy_notice_page() throws InterruptedException {
		
		pnpage.verifyPrivacyNoticelink();
	    
	}

}
