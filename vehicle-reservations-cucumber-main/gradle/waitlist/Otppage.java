package com.ford.auto.waitlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class Otppage extends Browser {
	WebDriver driver;
	WDSupport driverSupport;

	public Otppage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void OtpPage() {

		driverSupport.locateByXpath("//div[@id='otp']/input[@id='first']").sendKeys("000000");
		driverSupport.locateByXpath("//button[text()='Verify and Continue']").click();

	}

}
