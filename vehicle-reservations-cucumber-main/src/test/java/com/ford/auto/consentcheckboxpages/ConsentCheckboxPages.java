package com.ford.auto.consentcheckboxpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ConsentCheckboxPages extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ConsentCheckboxPages(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void verifyPartialprofilepage() throws InterruptedException {

		Thread.sleep(1000);

		WebElement verifypartialprofile = driverSupport.locateByXpath("//img[@class='SignUp_join_now_img__7Bx+l']");

		boolean pagetitle = verifypartialprofile.isDisplayed();

		Assert.assertTrue(pagetitle);
		System.out.println("User lands on the partialprofile page succesfully"+"*********");

	}

	public void newUserOnSignupage(String firstname, String lastname, String email, String phoneno, String zipcode)
			throws InterruptedException {

		driverSupport.locateByXpath("//input[@id='firstName']").sendKeys(firstname);

		driverSupport.locateByXpath("//input[@id='lastName']").sendKeys(lastname);

		driverSupport.locateByXpath("//input[@id='email']").sendKeys(email);
		driverSupport.locateByXpath("//input[@id='phoneNo']").sendKeys(phoneno);

		driverSupport.locateByXpath("//input[@id='homeZipCode']").sendKeys(zipcode);

	}

	public void userclicksConsentCheckbox() throws InterruptedException {
		Thread.sleep(2000);
		WebElement checkboxes = driverSupport.locateByXpath("//input[@data-testid='consents'][@type='checkbox']");
		
		// if checkbox is selected the Get Started button will gets enabled
		checkboxes.click();

		boolean actualvalue = checkboxes.isSelected();

		// Check if the button is disabled
		if (actualvalue) {
			System.out.println("Get Started Button is enabled" + "***********");
		} else {
			System.out.println("Get Started Button is disabled" + "**********");
		}

	}

}
