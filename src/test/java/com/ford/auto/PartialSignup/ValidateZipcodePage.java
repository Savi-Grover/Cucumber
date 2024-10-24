package com.ford.auto.PartialSignup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ValidateZipcodePage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ValidateZipcodePage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void paritalSignupagevalidation(String firstname, String lastname, String email, String phoneno,
			String zipcode) throws InterruptedException {

		driverSupport.locateByXpath("//input[@id='firstName']").sendKeys(firstname);

		driverSupport.locateByXpath("//input[@id='lastName']").sendKeys(lastname);

		driverSupport.locateByXpath("//input[@id='email']").sendKeys(email);
		driverSupport.locateByXpath("//input[@id='phoneNo']").sendKeys(phoneno);

		driverSupport.locateByXpath("//input[@id='homeZipCode']").sendKeys(zipcode);

		driverSupport.locateByXpath("//input[@data-testid='consents'][@type='checkbox']").click();

	}

	public void userclicksGetstartedbtn() throws InterruptedException {
		Thread.sleep(1000);
		driverSupport.locateByXpath("//button[text()='Get Started']").click();
		Thread.sleep(1000);
	}

	public void OtpPage() {

		driverSupport.locateByXpath("//div[@id='otp']/input[@id='first']").sendKeys("000000");
		driverSupport.locateByXpath("//button[text()='Verify and Continue']").click();

	}
	
	public void VaildZipcode() throws InterruptedException {
		
		Thread.sleep(2000);
		String expected = driverSupport.locateByXpath("//p[text()='Package Selection']").getText();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Package Selection"))

		{
			System.out.println("Package Selection has been displayed successfully."+"**********");
		} else {
			System.out.println("Package Selection has not displayed successfully."+"**********");
			Assert.fail();
		}
	}

	public void ValidateZipcodeErrormsg() {

		WebElement ZipcodeErrMsg = driverSupport.locateByXpath("//p[text()='We’re currently not available in your area.']");
		String actualErrorMessage = ZipcodeErrMsg.getText();
		String expectedErrorMessage = "We’re currently not available in your area.";

		// Validate error message for invalid Zipcode 
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		System.out.println("An error message for invalid Zipcode is displaying Succesfully."+"**********");

	}
}
