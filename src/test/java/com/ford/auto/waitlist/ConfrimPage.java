package com.ford.auto.waitlist;

import com.ford.auto.support.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.logging.Logger;
import com.ford.auto.support.WDSupport;

public class ConfrimPage extends PageBaseClass {
	public static final String CONFIRMPAGEURLEXCERPT = "/package-selection";

	public ConfrimPage(WebDriver driver) throws InterruptedException {
		super(driver,CONFIRMPAGEURLEXCERPT, 25);
	}

	public void clickonconfirm() throws InterruptedException {
		Logger.LogEnterMethod("");
		Thread.sleep(2000);
        driverSupport.locateByXpath("//button[text()='Confirm']").click();
		Thread.sleep(2000);
		driverSupport.locateByXpath("//button[@type='button']").click();
		Thread.sleep(2000);
		driverSupport.locateByXpath("//div[@data-testid='back-arrow']").click();

	}

	public String verifygetleasepackage() throws Exception {
		Logger.LogEnterMethod("");
		Thread.sleep(5000);

		String newpackage = driverSupport.locateByXpath("//div[@class='l-flex']//p").getText();

		System.out.println(newpackage);

		return newpackage;

	}

}
