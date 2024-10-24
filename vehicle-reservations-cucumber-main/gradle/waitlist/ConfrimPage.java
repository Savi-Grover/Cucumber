package com.ford.auto.waitlist;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ConfrimPage extends Browser {
	WebDriver driver;
	WDSupport driverSupport;

	public ConfrimPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void clickonconfirm() throws InterruptedException {
		
		Thread.sleep(2000);
        driverSupport.locateByXpath("//button[text()='Confirm']").click();
		Thread.sleep(2000);
		driverSupport.locateByXpath("//button[@type='button']").click();
		Thread.sleep(2000);
		driverSupport.locateByXpath("//img[contains(@class,'NavHeader_back-arrow')]").click();

	}

	public void verifygetleasepackage() throws Exception {
		Thread.sleep(2000);

		String newpackage = driverSupport.locateByXpath("//div[@class='l-flex']//p").getText();
		String expectedmsg = "$329.00/wk";
		System.out.println("Success Message :-" + newpackage + "****");
		//System.out.println(newpackage);
       //return newpackage;
		//String expected = alert.verifygetleasepackage();
		  Thread.sleep(3000);
		if (newpackage.contains(expectedmsg))

		{
			System.out.println("Switch to the new packages Successfully" + "**********");
		} else {
			
			System.out.println("New packages is not Switched Successfully" + "**********");
			Assert.fail();
		}

	}

}
