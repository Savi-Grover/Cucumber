package com.ford.auto.waitlist;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class RestartMembershipPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public RestartMembershipPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void clickonRestartbutton() throws InterruptedException {

		Thread.sleep(2000);

		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport.locateByXpath("//button[text()='Restart Membership']");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

	}

	public String verifyPackageSelectionpage() {

		String newpackage = driverSupport.locateByXpath("//p[text()='Package Selection']").getText();

		System.out.println(newpackage);

		return newpackage;
	}

}
