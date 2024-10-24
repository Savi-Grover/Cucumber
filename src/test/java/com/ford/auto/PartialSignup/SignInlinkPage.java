package com.ford.auto.PartialSignup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class SignInlinkPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public SignInlinkPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void LoginwithSignInLink() throws InterruptedException {
		Thread.sleep(3000);
		driverSupport.locateByXpath("//p[text()='Sign In']").click();

	}

	public void verifypagetitle() {

		WebElement verifysigninpage = driverSupport.locateByXpath("//img[@id='welcomeImg']");
		if (verifysigninpage.isDisplayed()) {
			System.out.println("Signup page verified successfully!");
		} else {
			System.out.println("Signup page verification failed!");
		}
	}

	public void LogintoDashboard() throws InterruptedException {

		Thread.sleep(3000);
		driverSupport.locateByXpath("//input[@id='emailAddress']").sendKeys("testmailgcv@yopmail.com");

		driverSupport.locateByXpath("//button[@id='continue']").click();

		Thread.sleep(3000);
		driverSupport.locateByXpath("//input[@id='password']").sendKeys("Ford123!");
		
		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport.locateByXpath("//button[text()='Sign in']");
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// Find and click the element
		element.click();

		
	}
		
		public void verifyDashboardpage() throws InterruptedException {
			
        Thread.sleep(3000);

		WebElement verifyDashboard = driverSupport.locateByXpath("//h4[@class='PickupInfoV2_heading__knKDp']");
		String actualErrorMessage = verifyDashboard.getText();
		String expectedErrorMessage = "Pickup Pending";

		// Validate error message
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

		System.out.println("login to the dashboard with SignIn link succesfully");

	}

}
