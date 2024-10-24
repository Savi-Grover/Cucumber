package com.ford.auto.activepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class SignInWithVaildaddress extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public SignInWithVaildaddress(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void signInwithVaildaddress(String email, String Password) throws InterruptedException {

		Thread.sleep(3000);

		WebElement scrolldown = driverSupport.locateByXpath("//p[text()='Already signed up?']");

		// Scroll down to the bottom of the webpage
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", scrolldown);
		driverSupport.locateByXpath("//p[text()='Sign In']").click();

		Thread.sleep(2000);

		driverSupport.locateByXpath("//input[@placeholder='Enter email']").sendKeys(email);

		driverSupport.locateByXpath("//button[@id='continue']").click();

		driverSupport.locateByXpath("//input[@id='password']").sendKeys(Password);

		Thread.sleep(2000);
		driverSupport.locateByXpath("//button[text()='Sign in']").click();

	}

	public void verifyactivehomepage() throws InterruptedException {
		Thread.sleep(5000);
		// Verify the dashboard page
		WebElement dashboardHeading = driverSupport.locateByXpath("//h2[text()='MILEAGE SNAPSHOT']");
		String actualDashboardHeading = dashboardHeading.getText();

		String expectedDashboardHeading = "MILEAGE SNAPSHOT";
		Assert.assertEquals(actualDashboardHeading, expectedDashboardHeading, "Dashboard page heading does not match");
	}

}
