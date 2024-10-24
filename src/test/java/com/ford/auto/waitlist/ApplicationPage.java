package com.ford.auto.waitlist;

import com.ford.auto.support.PageBaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.logging.Logger;
import com.ford.auto.support.WDSupport;
import org.openqa.selenium.WebElement;

public class ApplicationPage extends PageBaseClass {
	public static final String AGREETOWRITTENINSTRUCTIONSCHECKBOXLOCATOR = "/html/body/div[1]/div[3]/div/div/form/div[1]/div[6]/div/div/input";
	public static final String DRIVERSLICENSELOCATOR = "//input[@id='driversLicenseNumber']";
	public static final String BIRTHMONTHLOCATOR = "//input[@id='birthMonth']";
	public static final String BIRHTDAYLOCATOR = "//input[@id='birthDay']";
	public static final String BIRTHYEARLOCATOR = "//input[@id='birthYear']";
	public static final String ADDRESSLOCATOR = "//input[@id='homeAddress']";
	public static final String CITYLOCATOR = "//input[@id='city']";
	public static final String STATELOCATOR = "//input[@id='state']";
	public static final String ZIPCODELOCATOR = "//input[@id='zipCode']";
	public static final String SUBMITLOCATOR = "//button[text()='Submit']";
	public static final String APPLICATIONPAGE_PAGEURLEXTRACT = "additional-profile";

	public ApplicationPage(WebDriver driver) throws InterruptedException {
		super(driver, APPLICATIONPAGE_PAGEURLEXTRACT, 25);
		
}
	
	public void ApplicationPage(String DLnumber,String month,String day,String year,String address,String city,String state,String zipCode) throws InterruptedException {

		Logger.LogEnterMethod("");
		driverSupport.locateByXpath(DRIVERSLICENSELOCATOR).sendKeys(DLnumber);
		
		driverSupport.locateByXpath(BIRTHMONTHLOCATOR).sendKeys(month);
		
		driverSupport.locateByXpath(BIRHTDAYLOCATOR).sendKeys(day);
		
		driverSupport.locateByXpath(BIRTHYEARLOCATOR).sendKeys(year);
		
		driverSupport.locateByXpath(ADDRESSLOCATOR).sendKeys(address);
		
		
		driverSupport.locateByXpath(CITYLOCATOR).sendKeys(city);
		
		
		driverSupport.locateByXpath(STATELOCATOR).sendKeys(state);
		
		
		driverSupport.locateByXpath(ZIPCODELOCATOR).sendKeys(zipCode);
		Logger.LogInfo("Get agree to providing written instructions box, wait 2 seconds and click");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport
				.locateByXpath(AGREETOWRITTENINSTRUCTIONSCHECKBOXLOCATOR);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();
		WDSupport.waitUntilElementToBeSelected(driver,10, element);

		WebElement submitButton =
		driverSupport.locateByXpath(SUBMITLOCATOR);
		submitButton.click();
		Logger.LogInfo("Wait to see if the submit button is gone.");
		WDSupport.waitUntilElementIsGoneFromDOM(driver, 25, submitButton);
	}

	public void applicationApprovalPage() throws InterruptedException{
		Logger.LogEnterMethod("");

		driverSupport.locateByXpath(DRIVERSLICENSELOCATOR).sendKeys("123");
		
		driverSupport.locateByXpath(BIRTHMONTHLOCATOR).sendKeys("05");
		
		driverSupport.locateByXpath(BIRHTDAYLOCATOR).sendKeys("05");
		
		driverSupport.locateByXpath(BIRTHYEARLOCATOR).sendKeys("1995");
		
		driverSupport.locateByXpath(ADDRESSLOCATOR).sendKeys("3200 GLENDALE AVE");
		
	    driverSupport.locateByXpath(CITYLOCATOR).sendKeys("TOLEDO");
		
	    driverSupport.locateByXpath(STATELOCATOR).sendKeys("OH");
		
	    driverSupport.locateByXpath(ZIPCODELOCATOR).sendKeys("66621");
		
		driverSupport.locateByXpath("//input[@id='b8967549-c8e5-46e8-88ae-ef30b7d1f1fd']").click();
		
		driverSupport.locateByXpath(SUBMITLOCATOR).click();
	}
}
