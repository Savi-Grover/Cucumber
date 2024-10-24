package com.ford.auto.applicationapprovalpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class Approvalpage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public Approvalpage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void Validateinvalidlicensenumber() throws InterruptedException {

		String errorMessage = driverSupport.locateByXpath("//p[text()='You need at least 3 characters']").getText();
		System.out.println("error message displaying on the application page : " + errorMessage + "*******");

		
		Thread.sleep(3000);
		if (errorMessage.contains("You need at least 3 characters"))

		{
			System.out.println("An error msg  displayed Successfully");
		} else {
			Assert.fail();

		}

	}

}
