package com.ford.auto.RidecellPageobjects;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class SelectcountryfromDropdown extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public SelectcountryfromDropdown(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void selectCountryName(String countryname) throws InterruptedException {
		Thread.sleep(5000);
		driverSupport.locateByXpath("//button[@aria-label='Open']").click();

		WebElement dropdownvalue = driverSupport.locateByXpath("//input[@aria-autocomplete='list']");

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.chord(Keys.CONTROL)).perform();
		actions.sendKeys(Keys.DELETE).perform();
		actions.click(dropdownvalue).sendKeys(countryname).build().perform();
		

		if (countryname.equals("San Diego")) {
			actions.sendKeys(Keys.ENTER).build().perform();
		} else {
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			actions.sendKeys(Keys.ENTER).build().perform();
		}
		Thread.sleep(3000);

	}
	
	

}
