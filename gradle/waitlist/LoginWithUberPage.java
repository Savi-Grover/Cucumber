package com.ford.auto.waitlist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class LoginWithUberPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public LoginWithUberPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void loginWithUber() throws InterruptedException {
		Thread.sleep(1000);
		driverSupport.locateByXpath("//button[text()='Login with Uber']").click();
	}

	public void signInwithUber(String uberEmail, String uberPassword) throws InterruptedException {

		Thread.sleep(1000);
		driverSupport.locateByXpath("//a[text()='Sign In']").click();

		driverSupport.locateByXpath("//input[@placeholder='Enter phone number or email']").sendKeys(uberEmail);

		driverSupport.locateByXpath("//button[@data-testid='forward-button']").click();
		/*
		 * Thread.sleep(2000); List<WebElement> btnLoginWithPassword = driver
		 * .findElements(By.xpath("//input[@placeholder='Enter your password']"));
		 * //driverSupport.locateByXpath("//input[@placeholder='Enter your password']").
		 * sendKeys(uberPassword);
		 * 
		 * if (btnLoginWithPassword.size() > 0) {
		 * 
		 * btnLoginWithPassword.get(0).sendKeys(uberPassword);
		 * 
		 * System.out.println("Element is present");
		 * 
		 * }else {
		 * 
		 * System.out.println("Element is not present"); }
		 */
		
		Thread.sleep(2000);
		try {
			driverSupport.locateByXpath("//button[@data-testid='Login with password']").click();
			driverSupport.locateByXpath("//input[@placeholder='Enter your password']").sendKeys(uberPassword);
			

          } catch (Exception e) {
			driverSupport.locateByXpath("//input[@placeholder='Enter your password']").sendKeys(uberPassword);
		}

		driverSupport.locateByXpath("//div[text()='Next']").click();

	}

	public void selectfordDriveImage() throws InterruptedException {

		WebElement FordDriveImage = driverSupport.locateByXpath(
				"//img[@src=\"https://tb-static.uber.com/prod/vs-unified-marketplace-web/Red_Ford_Mach_E_flipped.png\"]");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FordDriveImage);

		FordDriveImage.click();

		Thread.sleep(5000);

		driverSupport.locateByXpath("(//div[@data-testid='button'])[2]").click();

	}

}
