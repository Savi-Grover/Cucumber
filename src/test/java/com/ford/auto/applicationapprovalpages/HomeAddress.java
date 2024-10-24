package com.ford.auto.applicationapprovalpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class HomeAddress extends Browser{
	WebDriver driver;
	WDSupport driverSupport;

	public HomeAddress(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}
	
	public void validateHomeAddress() throws InterruptedException {
		
		String errorMessage = driverSupport.locateByXpath("//p[text()='Please do not use special characters ( ), . # /']").getText();
		System.out.println("error message displaying on the application page : " + errorMessage + "*******");

		
		Thread.sleep(2000);
		if (errorMessage.contains("Please do not use special characters ( ), . # /"))

		{
			System.out.println("An error msg  displayed Successfully");
		} else {
			Assert.fail();

		}
		
		
		
	}

}
