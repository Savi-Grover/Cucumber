package com.ford.auto.activepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class leasepackagepage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public leasepackagepage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public String verifyleasepackage(String packagename) throws InterruptedException {

		Thread.sleep(3000);

		WebElement chevronrightarrow = driverSupport.locateByXpath("(//i[contains(@class,'chevron-right')])[1]");
        chevronrightarrow.click();
		Thread.sleep(3000);

		WebElement scrolldown = driverSupport.locateByXpath("//h4[text()='Lease Package']");
		// Scroll down to the bottom of the webpage
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", scrolldown);
		Thread.sleep(5000);
		String packagepage = driverSupport.locateByXpath("//div[@class='l-flex']//p").getText();
		return packagepage;

	}

}
