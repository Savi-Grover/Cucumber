package com.ford.auto.RidecellPageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;
import com.ford.auto.waitlist.RegisterPage;

public class SearchwithMail extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public SearchwithMail(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void searchWithEmailID(String uberEmail) throws InterruptedException{

		driverSupport.locateByXpath("//button[contains(@class,'ToolbarButton')]").click();

		WebElement email = driverSupport
				.locateByXpath("//input[@placeholder='By ID, vin, license plate, or customer name, and email']");
		
		//String uberEmail = RegisterPage.getRandomEmailId();

		//System.out.println("UberEmail;" + uberEmail);

		email.sendKeys(uberEmail);
		Thread.sleep(7000);
		
		//click on ClickIconsymbol
         driverSupport.locateByXpath("//a[@class='webElements-IconButton-IconButton'][1]").click();

	}

}
