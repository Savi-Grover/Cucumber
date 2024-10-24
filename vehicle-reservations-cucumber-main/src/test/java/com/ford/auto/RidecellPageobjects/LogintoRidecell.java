package com.ford.auto.RidecellPageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class LogintoRidecell extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public LogintoRidecell(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void loginpageRidecell(String email, String password) throws InterruptedException {
		
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://oval2-uat.ridecell.com/platform-one/platform/san-diego/scheduled_rentals/list");

		driverSupport.locateByXpath("//input[@name='username']").sendKeys(email);

		driverSupport.locateByXpath("//input[@name='password']").sendKeys(password);

		driverSupport.locateByXpath("//button[@type='submit']").click();

	}
	
	/*
	 * public String verifyScheduledRentals() throws Exception {
	 * 
	 * Thread.sleep(2000);
	 * 
	 * String Homepagetitle =
	 * driverSupport.locateByXpath("//*[text()='Scheduled Rentals']").getText();
	 * 
	 * System.out.println(Homepagetitle);
	 * 
	 * return Homepagetitle;
	 * 
	 * }
	 */
	
public void loginWithRidecell() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://oval2-uat.ridecell.com/platform-one/platform/san-diego/scheduled_rentals/list");

		driverSupport.locateByXpath("//input[@name='username']").sendKeys("ST37@ford.com");

		driverSupport.locateByXpath("//input[@name='password']").sendKeys("Sangi@1234!");

		driverSupport.locateByXpath("//button[@type='submit']").click();

	}

}

