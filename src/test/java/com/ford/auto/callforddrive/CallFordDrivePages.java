package com.ford.auto.callforddrive;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class CallFordDrivePages extends Browser{
	
	WebDriver driver;
	WDSupport driverSupport;

	public CallFordDrivePages(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}
	
	public void clickOnSignInLink() throws InterruptedException {

		Thread.sleep(3000);

		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport.locateByXpath("//p[text()='Sign In']");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();

	}
	
	public void LogintoDashboard(String Email, String password) throws InterruptedException {
		/*
		 * Thread.sleep(3000);
		 * driverSupport.locateByXpath("//p[text()='Sign In']").click();
		 */
		Thread.sleep(3000);
		driverSupport.locateByXpath("//input[@placeholder='Enter email']").sendKeys(Email);

		driverSupport.locateByXpath("//button[@id='continue']").click();

		Thread.sleep(3000);
		driverSupport.locateByXpath("//input[@id='password']").sendKeys(password);
		Thread.sleep(3000);
		driverSupport.locateById("next").click();

	}

	public void newdriverlandsonthe_dashboardpage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement dashboardstatus = driver.findElement(By.xpath("//h4[@class='PickupInfoV2_heading__knKDp']"));

		String verifystatus = dashboardstatus.getText();

		if (verifystatus.contains("Pickup Pending")) {

			System.out.println("New driver signIn  to the FordDrive application Successfully" + "**********");

		} else {

			System.out.println("New driver has not signIn  to the FordDrive application Successfully" + "**********");
			Assert.fail();

		}
	}
	
	
	//user clicks on the Schedule your pickup section dropdown Arrow
	
	public void clicksontheSchedulePickup() throws InterruptedException {

		Thread.sleep(2000);

		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport.locateByXpath("//div[text()='Schedule Your Pickup']");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();
		
		Thread.sleep(1000);
		
	WebElement	CallCustomerCareBtn =	driverSupport.locateByXpath("//button[text()='Call Customer Care']");
		
		if (CallCustomerCareBtn.isDisplayed()) {
			
			System.out.println("Call Ford Drive functionality in Pickup pending status dashboard page verified successfully!");
		} else {
			
			System.out.println("Call Ford Drive functionality in Pickup pending status dashboard page verification failed!");
		}

	}
	
	
	
}
