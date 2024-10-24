package com.ford.auto.createpasswordpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class createpasswordpages extends Browser {
	WebDriver driver;
	WDSupport driverSupport;

	public createpasswordpages(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void Passwordfield(String password) throws InterruptedException {

		Thread.sleep(2000);

		try {
			driverSupport.locateByXpath("//input[@data-testid='password']").sendKeys(password);

		} catch (Exception e) {
			driverSupport.locateByXpath("//input[@data-testid='password']").sendKeys(password);

		}
	}

	public void confirmPasswordfield(String confirmpassword) throws InterruptedException {

		Thread.sleep(2000);

		driverSupport.locateByXpath("//input[@data-testid='confirmation']").sendKeys(confirmpassword);
		// driverSupport.locateByXpath("//button[text()='Create Password']").click();
	}

	public void VerifycreatepasswordButton() throws InterruptedException {

		Thread.sleep(2000);
		WebElement buttonElement = driver.findElement(By.xpath("//button[text()='Create Password']"));

		boolean actualvalue = buttonElement.isEnabled();

		// Check if the button is disabled
		if (actualvalue) {
			System.out.println("Create password button should be enabled");
		} else {
			System.out.println("Create password button should be disabled");

		}

	}

}
