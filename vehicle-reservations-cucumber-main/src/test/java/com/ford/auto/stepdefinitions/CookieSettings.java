package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.footerlinks.CookieSettingsPage;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CookieSettings extends Browser {
	
	CookieSettingsPage cspage;
	
	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);
	
	
	
	
	@When("I click on the cookies setting link")
	public void i_click_on_the_cookies_setting_link() throws InterruptedException {
		
		cspage = new CookieSettingsPage(driver);
		
		cspage.verifyCookieSettingsLink();
		
	}
	@Then("the cookies setting options should be displayed within the same web page")
	public void the_cookies_setting_options_should_be_displayed_within_the_same_web_page() throws InterruptedException {
		
		cspage.verifyCookieSettingsPageTitle();
	    
	}


}
