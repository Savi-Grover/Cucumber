package com.ford.auto.applicationapprovalpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ValidateCheckBoxPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ValidateCheckBoxPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void ApplicationPage(String DLnumber, String month, String day, String year, String address, String city,
			String state, String zipCode) {

		driverSupport.locateByXpath("//input[@id='driversLicenseNumber']").sendKeys(DLnumber);

		driverSupport.locateByXpath("//input[@id='birthMonth']").sendKeys(month);

		driverSupport.locateByXpath("//input[@id='birthDay']").sendKeys(day);

		driverSupport.locateByXpath("//input[@id='birthYear']").sendKeys(year);

		driverSupport.locateByXpath("//input[@id='homeAddress']").sendKeys(address);

		driverSupport.locateByXpath("//input[@id='city']").sendKeys(city);

		driverSupport.locateByXpath("//input[@id='state']").sendKeys(state);

		driverSupport.locateByXpath("//input[@id='zipCode']").sendKeys(zipCode);

	}

	public void userclicksConsentCheckbox() throws InterruptedException {
		Thread.sleep(2000);
		WebElement checkboxes = driverSupport.locateByXpath("//input[@id='b8967549-c8e5-46e8-88ae-ef30b7d1f1fd']");

		// if checkbox is selected the submit button will gets enabled
		//checkboxes.click();

		boolean actualvalue = checkboxes.isSelected();

		// Check if the Submit Button is disabled
		if (actualvalue) {
			System.out.println("Submit Button is enabled" + "***********");
		} else {
			System.out.println("Submit Button is disabled" + "**********");
		}

	}

}
