package com.ford.auto.waitlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class SSNPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public SSNPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void enterSSNPage(String SSNno){

		driverSupport.locateByXpath("//input[@data-testid='ssn-input']").sendKeys("666212622");
		driverSupport.locateByXpath("//button[@type='submit']").click();

	}
	
	
	

}
