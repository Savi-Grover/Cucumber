package com.ford.auto.footerlinks;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class CookieSettingsPage extends Browser {
	
	WebDriver driver;
	WDSupport driverSupport;

	public CookieSettingsPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void verifyCookieSettingsLink() throws InterruptedException {


		Thread.sleep(2000);

		String pagetitle = driverSupport.locateByXpath("//p[text()='Enter the six-digit verification code sent to ']").getText();

		System.out.println("PageTiltle " + pagetitle);

		if (pagetitle.contains("Enter the six-digit verification code sent to "))

		{
			System.out.println("Switch to the Home page Successfully");
		} else {
			Assert.fail();
		}

		WebElement footer = driverSupport.locateByXpath("//a[@id='cookie']");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		Thread.sleep(3000);
		footer.click();

	}

	public void verifyCookieSettingsPageTitle() throws InterruptedException {

		Thread.sleep(2000);
		String CStitle = driverSupport.locateByXpath("//h2[@id='ot-pc-title']").getText();

		if (CStitle.contains("Cookie Settings")) {

			System.out.println("Switch to the Cookie Settings page Successfully");
		} else {
			Assert.fail();
		}

		driverSupport.locateByXpath("//button[text()='Confirm My Choices']").click();

	}

}
