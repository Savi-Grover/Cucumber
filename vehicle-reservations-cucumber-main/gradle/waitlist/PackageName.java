package com.ford.auto.waitlist;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class PackageName extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public PackageName(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void PackageNamePage(String packagename) throws InterruptedException {
		
		Thread.sleep(3000);
		driverSupport.locateByXpath("//*[@class='mileage-package__amount']//*[contains(text(),'" + packagename + "')]")
				.click();

	}

	public void clicknext() throws InterruptedException {
		
		Thread.sleep(2000);
		driverSupport.locateByXpath("//button[text()='Next']").click();

	}
	
public void NewPackageName(String packagename) throws InterruptedException {
		
		Thread.sleep(5000);
		
		// Scroll to the element using JavaScriptExecutor
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element = driverSupport.locateByXpath("//*[@class='mileage-package__amount']//*[contains(text(),'" + packagename + "')]");
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
                element.click();

	}


}
