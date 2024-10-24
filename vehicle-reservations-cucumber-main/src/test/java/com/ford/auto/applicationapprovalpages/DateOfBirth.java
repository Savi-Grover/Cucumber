package com.ford.auto.applicationapprovalpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class DateOfBirth extends Browser{
	
	WebDriver driver;
	WDSupport driverSupport;

	public DateOfBirth(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}
	
	public void validateDateOfBirth() throws InterruptedException {
		

		String errorMessage = driverSupport.locateByXpath("//span[contains(@class,'BirthDateFormFields')]").getText();
		System.out.println("error message displaying on the application page : " + errorMessage + "*******");

		
		Thread.sleep(2000);
		if (errorMessage.contains("Please enter a valid date of birth"))

		{
			System.out.println("An error msg  displayed Successfully");
		} else {
			Assert.fail();

		}
	}

}
