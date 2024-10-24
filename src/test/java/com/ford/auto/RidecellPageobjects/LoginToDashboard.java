package com.ford.auto.RidecellPageobjects;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class LoginToDashboard extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public LoginToDashboard(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void LogintoDashboard(String Email) throws InterruptedException {
		Thread.sleep(3000);
		driverSupport.locateByXpath("//p[text()='Sign In']").click();
		Thread.sleep(3000);
		driverSupport.locateByXpath("//input[@placeholder='Enter email']").sendKeys(Email);

		driverSupport.locateByXpath("//button[@id='continue']").click();

		Thread.sleep(3000);
		driverSupport.locateByXpath("//input[@id='password']").sendKeys("Ford123!");
		Thread.sleep(3000);
		driverSupport.locateById("next").click();

	}
	
	public String activateStatus() {

		String newpackage = driverSupport.locateByXpath("//h2[text()='MILEAGE SNAPSHOT']").getText();

		System.out.println(newpackage);

		return newpackage;
	}
	
	public String activatePPStatus() {

		String newpackage = driverSupport.locateByXpath("//p[text()='Return Details:']").getText();

		System.out.println(newpackage);

		return newpackage;
	}
	
	public String closedStatus() {

		String closestatus = driverSupport.locateByXpath("//div[contains(@class,'ClosedDetails')]").getText();

		System.out.println(closestatus);

		return closestatus;
	}

}
