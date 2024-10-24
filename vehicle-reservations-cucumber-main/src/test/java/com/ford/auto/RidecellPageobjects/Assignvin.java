package com.ford.auto.RidecellPageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class Assignvin extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	String togglebtnXpath = "//span[@class='MuiIconButton-label']";

	public Assignvin(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void assignVinNo(String Vinno) throws InterruptedException {

		Actions actions = new Actions(driver);

		// WebElement clicktoggleBtnpresent
		// =driverSupport.locateByXpath("//span[text()='Try the new panel']");
		Thread.sleep(3000);
		if (driverSupport.locateByXpath("//span[text()='Try the new panel']").isDisplayed()) {

			driverSupport.locateByXpath(togglebtnXpath).click();

		}
		
		WebElement assignvin = driverSupport.locateByXpath("//span[text()='Assign Vehicle']");
		
		Thread.sleep(5000);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		  executor.executeScript("arguments[0].click();", assignvin);
		 

		WebElement enterVinNum = driverSupport.locateByXpath("//div[@data-test-id='onDemandVehicleSearch']");
		Thread.sleep(2000);
        actions.click(enterVinNum).perform();
		actions.sendKeys(enterVinNum, Vinno).build().perform();
		
		Thread.sleep(5000);
		actions.sendKeys(Keys.ARROW_UP).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		WebElement assignvehicle = driverSupport.locateByXpath("(//span[text()='Assign Vehicle'])[2]");
		actions.click(assignvehicle).build().perform();
		driverSupport.locateByXpath("//button[text()='Yes']").click();
        driverSupport.locateByXpath("//button[text()='OK']").click();
 
		driverSupport
				.locateByXpath("//div[contains(@class,'-SidePanelLarge')]//div[@class='webElements-SidePanel-close']")
				.click();
		Thread.sleep(2000);

	}

	public String verifyUpcomingStatus() throws Exception {

		// Verify the status Upcoming

		String upcomingstatus = driverSupport.locateByXpath("//*[text()='Upcoming']").getText();

		System.out.println(upcomingstatus);

		return upcomingstatus;

	}

}
