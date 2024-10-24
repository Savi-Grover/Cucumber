package com.ford.auto.RidecellPageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class OpenLifecycle extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public OpenLifecycle(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void searchWithVinNo(String Vinno) throws InterruptedException {

		Actions actions = new Actions(driver);

		WebElement searchvin = driverSupport.locateByXpath("//button[contains(@class,'ToolbarButton')]");
		Thread.sleep(9000);
		actions.click(searchvin).build().perform();

		// using action class enter the vin no

		WebElement entervinNo = driverSupport.locateByXpath("//input[@placeholder='By VIN/License plate']");
		Thread.sleep(5000);
		actions.sendKeys(entervinNo, Vinno).build().perform();

		WebElement expandlifecycle = driverSupport.locateByXpath("//button[@testid='expand-lifecycle-step']");
		Thread.sleep(5000);
		actions.click(expandlifecycle).build().perform();

		// click on progress
		Thread.sleep(5000);
		WebElement clickprogress = driverSupport
				.locateByXpath("(//select[contains(@data-test-id,'DataTable__TableRow__DataTable__TableRow')])[1]");

		Select dropdown = new Select(clickprogress);
		dropdown.selectByVisibleText("Completed");
        WebElement clickYes = driverSupport.locateByXpath("//button[text()='Yes']");
        clickYes.click();
        
        Thread.sleep(5000);
		WebElement clickQueue = driverSupport.locateByXpath("//select[contains(@data-test-id,'DataTable__TableRow__DataTable__TableRow')]");
		Select dropdown2 = new Select(clickQueue);
        dropdown2.selectByVisibleText("Completed");
        WebElement clickYesbtn = driverSupport.locateByXpath("//button[text()='Yes']");
        clickYesbtn.click();
        
        Thread.sleep(2000);

	}

	public String verifyPendingPickupStatus() throws Exception {

		// Verify the status pending pickup status

		String pendingpickupstatus = driverSupport.locateByXpath("//div[text()='4 | Pending Pickup']").getText();

		System.out.println(pendingpickupstatus);

		return pendingpickupstatus;

	}

}
